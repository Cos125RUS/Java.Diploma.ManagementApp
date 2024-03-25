package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.model.entity.Storage;
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
    public List<Storage> findAll() {
        return service.findAll();
    }

    @PostMapping("/addStorage")
    public Storage addStorage(@RequestBody Storage storage) {
        return service.addStorage(storage);
    }

    @PutMapping("/update/{id}")
    public Storage update(@RequestBody Storage storage, @PathVariable Long id) {
        Storage oldStorage = service.findById(id).get();
        storage.setId(oldStorage.getId());
        return service.update(storage);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/findStorage/{id}")
    public Storage findStorage(@PathVariable Long id) {
        return service.findById(id).get();
    }
}
