package com.github.vinicius2335.server.api.controller;

import com.github.vinicius2335.server.api.representation.model.request.MemoryRequest;
import com.github.vinicius2335.server.domain.model.Memory;
import com.github.vinicius2335.server.domain.service.MemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/memories")
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class MemoryController {
    private final MemoryService memoryService;

    /**
     * Endpoint responsavel por encontrar todas as memórias.
     * @return Lista de Memórias.
     */
    @GetMapping
    public ResponseEntity<List<Memory>> getAllMemories(){
        return ResponseEntity.ok(memoryService.findAll());
    }

    /**
     * Endpoint responsáver por procurar os detalhes de uma memória pelo id.
     * @param idMemory id da memória.
     * @return uma memória.
     */
    @GetMapping("/{idMemory}")
    public ResponseEntity<Memory> getMemoryById(@PathVariable UUID idMemory){
        return ResponseEntity.ok(memoryService.findyMemory(idMemory));
    }

    /**
     * Endpoint responsável por criar uma nova memória
     * @param request representa uma memória a ser criada.
     * @return a memória criada.
     */
    @PostMapping
    public ResponseEntity<Memory> createNewMemory(@RequestBody MemoryRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memoryService.createNewMemory(request));
    }

    /**
     * Endpoint responsável por atualizar uma memória.
     * @param idMemory id da memória.
     * @param request representa a memória a ser atualizada.
     * @return nada.
     */
    @PutMapping("/{idMemory}")
    public ResponseEntity<Void> updateMemory(@PathVariable UUID idMemory, @RequestBody MemoryRequest request){
        memoryService.updateMemoryOrThrows(idMemory, request);

        return ResponseEntity
                .noContent()
                .build();
    }

    // TODO - delete talvez
}
