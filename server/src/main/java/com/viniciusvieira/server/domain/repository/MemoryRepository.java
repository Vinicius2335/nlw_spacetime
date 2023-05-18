package com.viniciusvieira.server.domain.repository;

import com.viniciusvieira.server.domain.model.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemoryRepository extends JpaRepository<Memory, UUID> {
}
