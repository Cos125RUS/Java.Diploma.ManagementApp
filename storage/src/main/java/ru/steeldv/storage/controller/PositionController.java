package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.entity.Position;
import ru.steeldv.storage.service.PositionService;

import java.util.List;

/**
 * Позиции на остатках
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/position")
public class PositionController {
    private final PositionService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Position>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findByItemId/{itemId}")
    public ResponseEntity<Position> findByItemId(@PathVariable Long itemId) {
        return ResponseEntity.ok(service.findByItemId(itemId));
    }

    @PostMapping("/addPosition")
    public ResponseEntity<Position> addPosition(@RequestBody Position position) {
        return ResponseEntity.ok(service.addPosition(position));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Position> update(@RequestBody Position position, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(position, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findPosition/{id}")
    public ResponseEntity<Position> findPosition(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
