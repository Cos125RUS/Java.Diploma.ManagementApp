package ru.steeldv.front.service.storage;

import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.model.storage.StorageUnit;

import java.util.List;

public interface StorageUnitService {
    List<StorageUnit> findAllStorageUnit();

    StorageUnit addStorageUnit(StorageUnit storageUnit);

    StorageUnit updateStorageUnit(StorageUnit storageUnit, Long id);

    boolean deleteStorageUnit(Long id);

    StorageUnit findStorageUnit(Long id);

    List<StorageUnit> findStorageUnitByAvailabilityId(Long id);
}
