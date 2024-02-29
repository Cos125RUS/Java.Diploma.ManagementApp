package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.model.dto.StorageUnit;
import ru.steeldv.storage.service.StorageUnitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/storageUnit")
public class StorageUnitController {
    private final StorageUnitService service;

    @GetMapping("/findAll")
    public List<StorageUnit> findAll() {
        return service.getAllStorageUnits();
    }

    @PostMapping("/addStorageUnit")
    public StorageUnit addStorageUnit(@RequestBody StorageUnit storageUnit) {
        return service.addStorageUnit(storageUnit);
    }

    @PutMapping("/update/{id}")
    public StorageUnit update(@RequestBody StorageUnit storageUnit, @PathVariable Long id) {
        StorageUnit oldStorageUnit = service.findById(id).get();
        storageUnit.setId(oldStorageUnit.getId());
        return service.update(storageUnit);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/findStorageUnit/{id}")
    public StorageUnit findStorageUnit(@PathVariable Long id) {
        return service.findById(id).get();
    }

    @GetMapping("/findByAvailabilityId/{id}")
    public List<StorageUnit> findByAvailabilityId(@PathVariable Long id) {
        return service.findByAvailabilityId(id);
    }
}
