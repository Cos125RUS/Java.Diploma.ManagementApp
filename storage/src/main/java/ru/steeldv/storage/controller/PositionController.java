package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
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
    public List<Position> findAll() {
        return service.findAll();
    }

    @GetMapping("/findByItemId/{itemId}")
    public Position findByItemId(@PathVariable Long itemId) {
        return service.findByItemId(itemId);
    }

    @PostMapping("/addPosition")
    public Position addPosition(@RequestBody Position position) {
        return service.addPosition(position);
    }

    @PutMapping("/update/{id}")
    public Position update(@RequestBody Position position, @PathVariable Long id) {
        Position oldPosition = service.findById(id).get();
        position.setId(oldPosition.getId());
        return service.update(position);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/findPosition/{id}")
    public Position findPosition(@PathVariable Long id) {
        return service.findById(id).get();
    }

}
