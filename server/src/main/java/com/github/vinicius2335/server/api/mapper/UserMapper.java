package com.github.vinicius2335.server.api.mapper;

import com.github.vinicius2335.server.api.representation.model.response.UserResponse;
import com.github.vinicius2335.server.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserResponse toUserResponse(User user){
        return modelMapper.map(user, UserResponse.class);
    }
}
