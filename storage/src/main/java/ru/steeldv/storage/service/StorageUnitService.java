package ru.steeldv.storage.service;

import ru.steeldv.storage.entity.StorageUnit;

import java.util.List;
import java.util.Optional;

public interface StorageUnitService {
    List<StorageUnit> getAllStorageUnits();

    StorageUnit addStorageUnit(StorageUnit storageUnit);

    StorageUnit findById(Long id);

    StorageUnit update(StorageUnit storageUnit, Long id);

    void deleteById(Long id);

    List<StorageUnit> findByAvailabilityId(Long id);
}
