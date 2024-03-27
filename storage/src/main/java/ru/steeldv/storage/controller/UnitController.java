package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.entity.Unit;
import ru.steeldv.storage.service.UnitService;

import java.util.List;

/**
 * Общие остатки в указанных единицах измерения
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/unit")
public class UnitController {
    private final UnitService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Unit>> findAll() {
        return ResponseEntity.ok(service.getAllUnits());
    }

    @PostMapping("/addUnit")
    public ResponseEntity<Unit> addUnit(@RequestBody Unit unit) {
        return ResponseEntity.ok(service.addUnit(unit));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Unit> update(@RequestBody Unit unit, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(unit, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findUnit/{id}")
    public ResponseEntity<Unit> findUnit(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/findByPositionId/{id}")
    public ResponseEntity<Unit> findByPositionId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByPositionId(id));
    }
}
