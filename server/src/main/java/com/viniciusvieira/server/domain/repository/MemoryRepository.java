package com.viniciusvieira.server.domain.repository;

import com.viniciusvieira.server.domain.model.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MemoryRepository extends JpaRepository<Memory, UUID> {
    @Query(value = """
            SELECT * FROM memory
            ORDER BY created_at DESC
            """, nativeQuery = true)
    List<Memory> findAllOrderByDesc();
}
