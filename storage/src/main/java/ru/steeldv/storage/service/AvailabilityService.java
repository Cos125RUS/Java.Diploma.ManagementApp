package ru.steeldv.storage.service;

import ru.steeldv.storage.entity.Availability;

import java.util.List;
import java.util.Optional;

public interface AvailabilityService {
    List<Availability> getAllAvailability();

    Availability findById(Long id);

    Availability addAvailability(Availability availability);

    Availability update(Availability availability, Long id);

    void deleteById(Long id);

    List<Availability> findByPositionId(Long id);

}
