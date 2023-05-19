package com.viniciusvieira.server.domain.service;

import com.viniciusvieira.server.domain.exception.UserNotFoundException;
import com.viniciusvieira.server.domain.model.User;
import com.viniciusvieira.server.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CrudUserService {
    private final UserRepository userRepository;

    public User findUserByGithubId(int githubId) {
        return userRepository.findByGithubId(githubId)
                .orElseThrow(()  -> new UserNotFoundException("User not found"));
    }
}
