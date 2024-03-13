package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.model.entity.Unit;
import ru.steeldv.storage.service.UnitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/unit")
public class UnitController {
    private final UnitService service;

    @GetMapping("/findAll")
    public List<Unit> findAll() {
        return service.getAllUnits();
    }

    @PostMapping("/addUnit")
    public Unit addUnit(@RequestBody Unit unit) {
        return service.addUnit(unit);
    }

    @PutMapping("/update/{id}")
    public Unit update(@RequestBody Unit unit, @PathVariable Long id) {
        Unit oldUnit = service.findById(id).get();
        unit.setId(oldUnit.getId());
        return service.update(unit);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/findUnit/{id}")
    public Unit findUnit(@PathVariable Long id) {
        return service.findById(id).get();
    }

    @GetMapping("/findByPositionId/{id}")
    public Unit findByPositionId(@PathVariable Long id) {
        return service.findByPositionId(id);
    }
}
