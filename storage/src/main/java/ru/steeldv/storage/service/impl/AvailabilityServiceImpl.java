package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.entity.Availability;
import ru.steeldv.storage.entity.Position;
import ru.steeldv.storage.entity.Storage;
import ru.steeldv.storage.repository.AvailabilityRepository;
import ru.steeldv.storage.repository.PositionRepository;
import ru.steeldv.storage.repository.StorageRepository;
import ru.steeldv.storage.service.AvailabilityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailabilityServiceImpl implements AvailabilityService {
    private final AvailabilityRepository availabilityRepository;
    private final PositionRepository positionRepository;
    private final StorageRepository storageRepository;


    @Override
    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    @Override
    public Availability findById(Long id) {
        return availabilityRepository.findById(id).get();
    }

    @Override
    public Availability addAvailability(Availability availability) {
        Position position = positionRepository.findById(availability.getPosition().getId()).get();
        availability.setPosition(position);
        Storage storage = storageRepository.findById(availability.getStorage().getId()).get();
        availability.setStorage(storage);
        return availabilityRepository.save(availability);
    }

    @Override
    public Availability update(Availability availability, Long id) {
        Availability oldAvailability = availabilityRepository.findById(id).get();
        availability.setId(oldAvailability.getId());
        return availabilityRepository.save(availability);
    }
    @Override
    public void deleteById(Long id) {
        availabilityRepository.deleteById(id);
    }

    @Override
    public List<Availability> findByPositionId(Long id) {
        return availabilityRepository.findByPositionId(id).get();
    }

}
