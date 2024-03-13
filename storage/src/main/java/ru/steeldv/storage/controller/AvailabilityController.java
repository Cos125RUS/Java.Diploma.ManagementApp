package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.model.entity.Availability;
import ru.steeldv.storage.service.AvailabilityService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/availability")
public class AvailabilityController {
    private final AvailabilityService service;

    @GetMapping("/findAll")
    public List<Availability> findAll() {
        return service.getAllAvailability();
    }

    @PostMapping("/addAvailability")
    public Availability addAvailability(@RequestBody Availability availability) {
        return service.addAvailability(availability);
    }

    @PutMapping("/update/{id}")
    public Availability update(@RequestBody Availability availability, @PathVariable Long id) {
        Availability oldAvailability = service.findById(id).get();
        availability.setId(oldAvailability.getId());
        return service.update(availability);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/findAvailability/{id}")
    public Availability findAvailability(@PathVariable Long id) {
        return service.findById(id).get();
    }

    @GetMapping("/findByPositionId/{id}")
    public List<Availability> findByPositionId(@PathVariable Long id) {
        return service.findByPositionId(id).get();
    }
}
