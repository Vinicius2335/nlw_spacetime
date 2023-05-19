package com.viniciusvieira.server.domain.service;

import com.viniciusvieira.server.api.mapper.MemoryMapper;
import com.viniciusvieira.server.api.representation.model.request.MemoryRequest;
import com.viniciusvieira.server.api.representation.model.response.MemoryResponse;
import com.viniciusvieira.server.domain.exception.MemoryNotFoundException;
import com.viniciusvieira.server.domain.model.Github;
import com.viniciusvieira.server.domain.model.Memory;
import com.viniciusvieira.server.domain.model.User;
import com.viniciusvieira.server.domain.repository.MemoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MemoryService {
    private final MemoryRepository memoryRepository;
    private final MemoryMapper memoryMapper;
    private final CrudUserService crudUserService;

    public List<Memory> findAllMemories() {
        return memoryRepository.findAllOrderByDesc();
    }

    public Memory findMemoryById(UUID idMemory) {
        return memoryRepository.findById(idMemory)
                .orElseThrow(() -> new MemoryNotFoundException("Memory not found"));
    }

    @Transactional
    public MemoryResponse createNewMemory(MemoryRequest memoryRequest, Github userGithubInfo) {
        Memory memory = memoryMapper.toDomainMemory(memoryRequest);
        Memory memorySaved = memoryRepository.save(memory);

        User userFound = crudUserService.findUserByGithubId(userGithubInfo.getId());
        memorySaved.setUserId(userFound);
        return memoryMapper.toMemoryResponse(memorySaved);
    }

    @Transactional
    public MemoryResponse updateMemoryById(UUID idMemory, MemoryRequest memoryRequest) {
        Memory memoryToUpdate = memoryMapper.toDomainMemory(memoryRequest);
        Memory memoryFound = findMemoryById(idMemory);

        memoryToUpdate.setId(memoryFound.getId());
        Memory memoryUpdated = memoryRepository.save(memoryToUpdate);
        return memoryMapper.toMemoryResponse(memoryUpdated);
    }

    @Transactional
    public void deleteMemoryById(UUID idMemory) {
        Memory memoryFound = findMemoryById(idMemory);
        memoryRepository.delete(memoryFound);
    }
}
