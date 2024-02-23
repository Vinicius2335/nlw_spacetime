package com.github.vinicius2335.server.domain.repository;

import com.github.vinicius2335.server.domain.model.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MemoryRepository extends JpaRepository<Memory, UUID> {
    /**
     * Remove uma memória do banco de dados pelo ID
     * Método criado porque o delete do jpaRepository não estava funcionando, parecia que nem estava sendo chamado
     * @param idMemory id da memória
     */
    @Modifying
    @Query("DELETE FROM Memory m WHERE m.id = :idMemory")
    void customDelete(UUID idMemory);
}