package com.viniciusvieira.server.domain.service;

import com.viniciusvieira.server.api.mapper.MemoryMapper;
import com.viniciusvieira.server.api.representation.model.response.MemoryResponse;
import com.viniciusvieira.server.domain.exception.MemoryNotFoundException;
import com.viniciusvieira.server.domain.model.Memory;
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

    public List<Memory> findAllMemories() {
        return memoryRepository.findAll();
    }

    public Memory findMemoryById(UUID idMemory) {
        return memoryRepository.findById(idMemory)
                .orElseThrow(() -> new MemoryNotFoundException("Memory not found"));
    }

    @Transactional
    public MemoryResponse createNewMemory(Memory memory) {
        Memory memorySaved = memoryRepository.save(memory);
        return memoryMapper.toMemoryResponse(memorySaved);
    }

    @Transactional
    public MemoryResponse updateMemoryById(UUID idMemory, Memory memory) {
        Memory memoryFound = findMemoryById(idMemory);
        memory.setId(memoryFound.getId());
        Memory memoryUpdated = memoryRepository.save(memory);
        return memoryMapper.toMemoryResponse(memoryUpdated);
    }

    @Transactional
    public void deleteMemoryById(UUID idMemory) {
        Memory memoryFound = findMemoryById(idMemory);
        memoryRepository.delete(memoryFound);
    }
}
