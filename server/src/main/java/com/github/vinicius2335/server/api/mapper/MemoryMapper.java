package com.github.vinicius2335.server.api.mapper;


import com.github.vinicius2335.server.api.representation.model.request.MemoryRequest;
import com.github.vinicius2335.server.domain.model.Memory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemoryMapper {
    private final ModelMapper modelMapper;

    public Memory toMemory(MemoryRequest memoryRequest){
        return modelMapper.map(memoryRequest, Memory.class);
    }
}
