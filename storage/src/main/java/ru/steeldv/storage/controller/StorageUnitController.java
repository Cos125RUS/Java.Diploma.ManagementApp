package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.entity.StorageUnit;
import ru.steeldv.storage.service.StorageUnitService;

import java.util.List;

/**
 * Остатки в указанных единицах измерения по обозначенному складу
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/storageUnit")
public class StorageUnitController {
    private final StorageUnitService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<StorageUnit>> findAll() {
        return ResponseEntity.ok(service.getAllStorageUnits());
    }

    @PostMapping("/addStorageUnit")
    public ResponseEntity<StorageUnit> addStorageUnit(@RequestBody StorageUnit storageUnit) {
        return ResponseEntity.ok(service.addStorageUnit(storageUnit));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StorageUnit> update(@RequestBody StorageUnit storageUnit, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(storageUnit, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findStorageUnit/{id}")
    public ResponseEntity<StorageUnit> findStorageUnit(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/findByAvailabilityId/{id}")
    public ResponseEntity<List<StorageUnit>> findByAvailabilityId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByAvailabilityId(id));
    }
}
