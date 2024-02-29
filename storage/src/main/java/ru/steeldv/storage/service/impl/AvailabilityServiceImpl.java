package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.model.dto.Availability;
import ru.steeldv.storage.model.dto.Position;
import ru.steeldv.storage.repository.AvailabilityRepository;
import ru.steeldv.storage.repository.PositionRepository;
import ru.steeldv.storage.service.AvailabilityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailabilityServiceImpl implements AvailabilityService {
    private final AvailabilityRepository availabilityRepository;
    private final PositionRepository positionRepository;


    @Override
    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    @Override
    public Optional<Availability> findById(Long id) {
        return availabilityRepository.findById(id);
    }

    @Override
    public Availability addAvailability(Availability availability) {
        Position position = positionRepository.findById(availability.getPosition().getId()).get();
        availability.setPosition(position);
        return availabilityRepository.save(availability);
    }

    @Override
    public Availability update(Availability availability) {
        return availabilityRepository.save(availability);
    }
    @Override
    public boolean deleteById(Long id) {
        availabilityRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<List<Availability>> findByPositionId(Long id) {
        return availabilityRepository.findByPositionId(id);
    }

}
