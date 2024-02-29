package ru.steeldv.storage.service;

import ru.steeldv.storage.model.dto.Availability;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AvailabilityService {
    List<Availability> getAllAvailability();

    Optional<Availability> findById(Long id);

    Availability addAvailability(Availability availability);

    Availability update(Availability availability);

    boolean deleteById(Long id);

    Optional<List<Availability>> findByPositionId(Long id);

}
