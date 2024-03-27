package ru.steeldv.front.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.front.service.storage.*;
import ru.steeldv.library.api.StorageApi;
import ru.steeldv.library.model.dto.nomenclature.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements AvailabilityService, PositionService, StorageService, StorageUnitService, UnitService {
    private final StorageApi storageApi;

    //    region storage

    @Override
    public List<Availability> findAllAvailability() {
        return storageApi.findAllAvailability();
    }

    @Override
    public Availability addAvailability(Availability availability) {
        return storageApi.addAvailability(availability);
    }

    @Override
    public Availability updateAvailability(Availability availability, Long id) {
        return storageApi.updateAvailability(availability, id);
    }

    @Override
    public boolean deleteAvailability(Long id) {
        return storageApi.deleteAvailability(id);
    }

    @Override
    public Availability findAvailability(Long id) {
        return storageApi.findAvailability(id);
    }

    @Override
    public List<Availability> findAvailabilityByPositionId(Long id) {
        return storageApi.findAvailabilityByPositionId(id);
    }
    //    endregion storage

    //    region availability

    @Override
    public Position findPositionByItemId(Long itemId) {
        return storageApi.findPositionByItemId(itemId);
    }

    @Override
    public Position addPosition(Position position) {
        return storageApi.addPosition(position);
    }

    @Override
    public Position updatePosition(Position position, Long id) {
        return storageApi.updatePosition(position, id);
    }

    @Override
    public boolean deletePosition(Long id) {
        return storageApi.deletePosition(id);
    }

    @Override
    public Position findPosition(Long id) {
        return storageApi.findPosition(id);
    }
//    endregion availability

    //    region position

    @Override
    public List<Storage> findAllStorage() {
        return storageApi.findAllStorage();
    }

    @Override
    public Storage addStorage(Storage storage) {
        return storageApi.addStorage(storage);
    }

    @Override
    public Storage updateStorage(Storage storage, Long id) {
        return storageApi.updateStorage(storage, id);
    }

    @Override
    public boolean deleteStorage(Long id) {
        return storageApi.deleteStorage(id);
    }

    @Override
    public Storage findStorage(Long id) {
        return storageApi.findStorage(id);
    }
//    endregion position

    //    region storageUnit

    @Override
    public List<StorageUnit> findAllStorageUnit() {
        return storageApi.findAllStorageUnit();
    }

    @Override
    public StorageUnit addStorageUnit(StorageUnit storageUnit) {
        return storageApi.addStorageUnit(storageUnit);
    }

    @Override
    public StorageUnit updateStorageUnit(StorageUnit storageUnit, Long id) {
        return storageApi.updateStorageUnit(storageUnit, id);
    }

    @Override
    public boolean deleteStorageUnit(Long id) {
        return storageApi.deleteStorageUnit(id);
    }

    @Override
    public StorageUnit findStorageUnit(Long id) {
        return storageApi.findStorageUnit(id);
    }

    @Override
    public List<StorageUnit> findStorageUnitByAvailabilityId(Long id) {
        return storageApi.findStorageUnitByAvailabilityId(id);
    }
//    endregion storageUnit

    //    region unit

    @Override
    public List<Unit> findAllUnit() {
        return storageApi.findAllUnit();
    }

    @Override
    public Unit addUnit(Unit unit) {
        return storageApi.addUnit(unit);
    }

    @Override
    public Unit updateUnit(Unit unit, Long id) {
        return storageApi.updateUnit(unit, id);
    }

    @Override
    public boolean deleteUnit(Long id) {
        return storageApi.deleteUnit(id);
    }

    @Override
    public Unit findUnit(Long id) {
        return storageApi.findUnit(id);
    }

    @Override
    public Unit findUnitByPositionId(Long id) {
        return storageApi.findUnitByPositionId(id);
    }
//    endregion unit

}
