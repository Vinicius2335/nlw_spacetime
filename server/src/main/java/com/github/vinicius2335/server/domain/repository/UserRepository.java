package com.github.vinicius2335.server.domain.repository;

import com.github.vinicius2335.server.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}