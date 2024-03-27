package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.entity.Storage;
import ru.steeldv.storage.service.StorageService;

import java.util.List;

/**
 * Склады
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/storage")
public class StorageController {
    private final StorageService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Storage>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/addStorage")
    public ResponseEntity<Storage> addStorage(@RequestBody Storage storage) {
        return ResponseEntity.ok(service.addStorage(storage));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Storage> update(@RequestBody Storage storage, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(storage, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findStorage/{id}")
    public ResponseEntity<Storage> findStorage(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
