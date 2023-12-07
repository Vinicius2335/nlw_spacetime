package com.github.vinicius2335.server.domain.repository;

import com.github.vinicius2335.server.domain.model.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemoryRepository extends JpaRepository<Memory, UUID> {
}