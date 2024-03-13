package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.model.entity.Availability;
import ru.steeldv.storage.model.entity.StorageUnit;
import ru.steeldv.storage.repository.AvailabilityRepository;
import ru.steeldv.storage.repository.StorageUnitRepository;
import ru.steeldv.storage.service.StorageUnitService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageUnitServiceImpl implements StorageUnitService {
    private final StorageUnitRepository storageUnitRepository;
    private final AvailabilityRepository availabilityRepository;

    @Override
    public List<StorageUnit> getAllStorageUnits() {
        return storageUnitRepository.findAll();
    }

    @Override
    public StorageUnit addStorageUnit(StorageUnit storageUnit) {
        Availability availability = availabilityRepository.findById(storageUnit.getAvailability().getId()).get();
        storageUnit.setAvailability(availability);
        return storageUnitRepository.save(storageUnit);
    }

    @Override
    public Optional<StorageUnit> findById(Long id) {
        return storageUnitRepository.findById(id);
    }

    @Override
    public StorageUnit update(StorageUnit storageUnit) {
        return storageUnitRepository.save(storageUnit);
    }

    @Override
    public boolean deleteById(Long id) {
        storageUnitRepository.deleteById(id);
        return true;
    }

    @Override
    public List<StorageUnit> findByAvailabilityId(Long id) {
        return storageUnitRepository.findByAvailabilityId(id).get();
    }
}
