package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.model.Item;
import ru.steeldv.storage.model.Position;
import ru.steeldv.storage.service.PositionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/position")
public class PositionController {
    private final PositionService service;

    @GetMapping("/findByItemId/{itemId}")
    public List<Position> findByItemId(@PathVariable Long itemId) {
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
