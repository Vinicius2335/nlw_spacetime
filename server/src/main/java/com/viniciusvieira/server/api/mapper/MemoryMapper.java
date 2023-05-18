package com.viniciusvieira.server.api.mapper;

import com.viniciusvieira.server.api.representation.model.response.MemoryResponse;
import com.viniciusvieira.server.domain.model.Memory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemoryMapper {
    private final ModelMapper modelMapper;

    public MemoryResponse toMemoryResponse(Memory memory){
        return modelMapper.map(memory, MemoryResponse.class);
    }
}
