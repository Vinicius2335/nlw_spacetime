package com.github.vinicius2335.server.domain.service;

import com.github.vinicius2335.server.api.mapper.MemoryMapper;
import com.github.vinicius2335.server.api.representation.model.request.MemoryRequest;
import com.github.vinicius2335.server.common.utils.ExtractEntityUtils;
import com.github.vinicius2335.server.common.utils.FileDeleteUtils;
import com.github.vinicius2335.server.domain.exception.BusinessRuleException;
import com.github.vinicius2335.server.domain.exception.MemoryNotFoundException;
import com.github.vinicius2335.server.domain.model.Memory;
import com.github.vinicius2335.server.domain.model.User;
import com.github.vinicius2335.server.domain.repository.MemoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemoryService {
    private final MemoryRepository memoryRepository;
    private final MemoryMapper memoryMapper;

    /**
     * Procura por todas as memórias. Se o conteúdo tiver mais de 115 caracteres, ele é quebrado para consumir menos.
     *
     * @return Lista de memórias
     */
    public List<Memory> findAll() {
        User user = ExtractEntityUtils.extractEntityFromContext();
        validateUserOrThrows(user);

        List<Memory> memories = memoryRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
        List<Memory> memoriesByUser = memories.stream()
                .filter(memory -> memory.getUser().getId().equals(user.getId()))
                .toList();

        memoriesByUser.forEach(memory -> {
            if (memory.getContent().length() > 115) {
                memory.setContent(memory.getContent().substring(0, 115).concat("..."));
            }
        });
        return memoriesByUser;
    }

    /**
     * Procura os detalhes de uma memória completa.
     *
     * @param idMemory id da memória procurada.
     * @return uma memória se encontrada ou lança uma exception.
     */
    public Memory findyMemory(UUID idMemory) {
        User user = ExtractEntityUtils.extractEntityFromContext();
        validateUserOrThrows(user);

        Memory memoryFound = findyMemoryByIdOrThrows(idMemory);

        if (!memoryFound.getUser().getId().equals(user.getId())){
            throw new BusinessRuleException("Erro interno ao tentar procurar uma memoria pelo id...");
        }

        return memoryFound;
    }

    private Memory findyMemoryByIdOrThrows(UUID idMemory) {
        return memoryRepository.findById(idMemory)
                .orElseThrow(() -> new MemoryNotFoundException("Memory not found by id..."));
    }

    /**
     * Cria uma nova memmória.
     *
     * @param request representa a mémoria a ser criada.
     * @return a memória criada.
     */
    @Transactional
    public Memory createNewMemory(MemoryRequest request) {
        User user = ExtractEntityUtils.extractEntityFromContext();
        validateUserOrThrows(user);

        Memory memoryToCreate = memoryMapper.toMemory(request);
        memoryToCreate.setUser(user);

        return memoryRepository.saveAndFlush(memoryToCreate);
    }

    /**
     * Atualiza uma memória
     * @param idMemory id da memória que deve ser atualizado
     * @param request campos alterados da nova memória
     */
    @Transactional
    public void updateMemoryOrThrows(UUID idMemory, MemoryRequest request) {
        User user = ExtractEntityUtils.extractEntityFromContext();
        validateUserOrThrows(user);

        // FIXME - Gambiarra
        // Por algum motivo isPublic de MemoryRequest sempre estava vindo false
        // tive que mudar o campo de boolean para String
        boolean isPublic = request.getIsPublic().equals("true");

        Memory memoryFound = findyMemoryByIdOrThrows(idMemory);

        if (!memoryFound.getUser().getId().equals(user.getId())){
            throw new BusinessRuleException("Erro interno ao tentar atualizar uma memória...");
        }

        Memory memoryToUpdate = memoryMapper.toMemory(request);
        memoryToUpdate.setId(memoryFound.getId());
        memoryToUpdate.setCreatedAt(memoryFound.getCreatedAt());
        memoryToUpdate.setUser(user);
        memoryToUpdate.setPublic(isPublic);

        memoryRepository.saveAndFlush(memoryToUpdate);
    }

    /**
     * Remove uma memória
     * @param idMemory id da memória que deve ser removida
     */
    @Transactional
    public void removeMemory(UUID idMemory){
        User user = ExtractEntityUtils.extractEntityFromContext();
        validateUserOrThrows(user);

        Memory memoryToDelete = findyMemoryByIdOrThrows(idMemory);

        memoryRepository.customDelete(memoryToDelete.getId());

        try {
            FileDeleteUtils.deleteFile(memoryToDelete.getCoverUrl());
        } catch (IOException e) {
            throw new BusinessRuleException("Error while try remove image from storage");
        }
    }

    private static void validateUserOrThrows(User user) {
        if (user.getId() == null){
            throw new BusinessRuleException("Erro interno...");
        }
    }
}
