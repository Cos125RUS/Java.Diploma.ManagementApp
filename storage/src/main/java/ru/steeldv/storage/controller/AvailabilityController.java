package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.entity.Availability;
import ru.steeldv.storage.service.AvailabilityService;

import java.util.List;

/**
 * Остатки по обозначенным складам
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/availability")
public class AvailabilityController {
    private final AvailabilityService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Availability>> findAll() {
        return ResponseEntity.ok(service.getAllAvailability());
    }

    @PostMapping("/addAvailability")
    public ResponseEntity<Availability> addAvailability(@RequestBody Availability availability) {
        return ResponseEntity.ok(service.addAvailability(availability));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Availability> update(@RequestBody Availability availability, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(availability, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findAvailability/{id}")
    public ResponseEntity<Availability> findAvailability(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/findByPositionId/{id}")
    public ResponseEntity<List<Availability>> findByPositionId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByPositionId(id));
    }
}
