package ru.steeldv.front.service.storage;

import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.model.storage.Availability;

import java.util.List;

public interface AvailabilityService {
    List<Availability> findAllAvailability();

    Availability addAvailability(Availability availability);

    Availability updateAvailability(Availability availability, Long id);

    boolean deleteAvailability(Long id);

    Availability findAvailability(Long id);

    List<Availability> findAvailabilityByPositionId(Long id);
}
