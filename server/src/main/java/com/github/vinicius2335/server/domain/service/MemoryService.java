package com.github.vinicius2335.server.domain.service;

import com.github.vinicius2335.server.api.mapper.MemoryMapper;
import com.github.vinicius2335.server.api.representation.model.request.MemoryRequest;
import com.github.vinicius2335.server.domain.exception.MemoryNotFoundException;
import com.github.vinicius2335.server.domain.model.Memory;
import com.github.vinicius2335.server.domain.repository.MemoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemoryService {
    private final MemoryRepository memoryRepository;
    private final MemoryMapper memoryMapper;

    /**
     * Procura por todas as memórias. Se o conteúdo tiver mais de 115 caracteres, ele é quebrado para consumir menos.
     * @return Lista de memórias
     */
    public List<Memory> findAll() {
        List<Memory> memories = memoryRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
        memories.forEach(memory -> {
            if (memory.getContent().length() > 115){
                memory.setContent(memory.getContent().substring(0, 115).concat("..."));
            }
        });
        return memories;
    }

    /**
     * Procura os detalhes de uma memória completa.
     * @param idMemory id da memória procurada.
     * @return uma memória se encontrada ou lança uma exception.
     */
    public Memory findyMemoryByIdOrThrows(UUID idMemory) {
        return memoryRepository.findById(idMemory)
                .orElseThrow(() -> new MemoryNotFoundException("Memory not found by id"));
    }

    /**
     * Cria uma nova memmória.
     * @param request representa a mémoria a ser criada.
     * @return a memória criada.
     */
    @Transactional
    public Memory createNewMemory(MemoryRequest request) {
        Memory memoryToCreate = memoryMapper.toMemory(request);
        return memoryRepository.saveAndFlush(memoryToCreate);
    }

    // TODO - validar se o id do usuário passado é valido
    @Transactional
    public void updateMemoryOrThrows(UUID idMemory, MemoryRequest request) {
        Memory memoryFound = findyMemoryByIdOrThrows(idMemory);

        Memory memoryToUpdate = memoryMapper.toMemory(request);
        memoryToUpdate.setId(memoryFound.getId());
        memoryToUpdate.setCreatedAt(memoryFound.getCreatedAt());
        memoryToUpdate.setPublic(memoryFound.isPublic());
        memoryToUpdate.setUser(memoryFound.getUser());

        memoryRepository.saveAndFlush(memoryToUpdate);
    }
}
