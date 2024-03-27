package ru.steeldv.front.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.service.storage.*;
import ru.steeldv.library.model.dto.nomenclature.Position;
import ru.steeldv.library.model.dto.nomenclature.Storage;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/storage")
public class StorageController {
    private final AvailabilityService availabilityService;
    private final PositionService positionService;
    private final StorageService storageService;
    private final StorageUnitService storageUnitService;
    private final UnitService unitService;

    @GetMapping("/position/findByItemId/{id}")
    public ResponseEntity<Position> findPositionByItemId(@PathVariable Long id) {
        return new ResponseEntity<>(positionService.findPositionByItemId(id), HttpStatus.OK);
    }

    @PostMapping("/storage/addStorage")
    public ResponseEntity<Storage> addStorage(@RequestBody Storage storage) {
        return new ResponseEntity<>(storageService.addStorage(storage), HttpStatus.OK);
    }

    @DeleteMapping("/storage/delete/{id}")
    public ResponseEntity<Boolean> deleteStorage(@PathVariable Long id) {
        return new ResponseEntity<>(storageService.deleteStorage(id), HttpStatus.OK);
    }
}
