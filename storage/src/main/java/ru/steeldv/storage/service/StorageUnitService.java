package ru.steeldv.storage.service;

import ru.steeldv.storage.model.entity.StorageUnit;

import java.util.List;
import java.util.Optional;

public interface StorageUnitService {
    List<StorageUnit> getAllStorageUnits();

    StorageUnit addStorageUnit(StorageUnit storageUnit);

    Optional<StorageUnit> findById(Long id);

    StorageUnit update(StorageUnit storageUnit);

    boolean deleteById(Long id);

    List<StorageUnit> findByAvailabilityId(Long id);
}
