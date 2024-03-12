package ru.steeldv.front.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.front.client.StorageClientApi;
import ru.steeldv.front.model.storage.*;
import ru.steeldv.front.service.storage.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements AvailabilityService, PositionService, StorageService, StorageUnitService, UnitService {
    private final StorageClientApi storageClientApi;

    //    region storage

    @Override
    public List<Availability> findAllAvailability() {
        return storageClientApi.findAllAvailability();
    }

    @Override
    public Availability addAvailability(Availability availability) {
        return storageClientApi.addAvailability(availability);
    }

    @Override
    public Availability updateAvailability(Availability availability, Long id) {
        return storageClientApi.updateAvailability(availability, id);
    }

    @Override
    public boolean deleteAvailability(Long id) {
        return storageClientApi.deleteAvailability(id);
    }

    @Override
    public Availability findAvailability(Long id) {
        return storageClientApi.findAvailability(id);
    }

    @Override
    public List<Availability> findAvailabilityByPositionId(Long id) {
        return storageClientApi.findAvailabilityByPositionId(id);
    }
    //    endregion storage

    //    region availability

    @Override
    public Position findPositionByItemId(Long itemId) {
        return storageClientApi.findPositionByItemId(itemId);
    }

    @Override
    public Position addPosition(Position position) {
        return storageClientApi.addPosition(position);
    }

    @Override
    public Position updatePosition(Position position, Long id) {
        return storageClientApi.updatePosition(position, id);
    }

    @Override
    public boolean deletePosition(Long id) {
        return storageClientApi.deletePosition(id);
    }

    @Override
    public Position findPosition(Long id) {
        return storageClientApi.findPosition(id);
    }
//    endregion availability

    //    region position

    @Override
    public List<Storage> findAllStorage() {
        return storageClientApi.findAllStorage();
    }

    @Override
    public Storage addStorage(Storage storage) {
        return storageClientApi.addStorage(storage);
    }

    @Override
    public Storage updateStorage(Storage storage, Long id) {
        return storageClientApi.updateStorage(storage, id);
    }

    @Override
    public boolean deleteStorage(Long id) {
        return storageClientApi.deleteStorage(id);
    }

    @Override
    public Storage findStorage(Long id) {
        return storageClientApi.findStorage(id);
    }
//    endregion position

    //    region storageUnit

    @Override
    public List<StorageUnit> findAllStorageUnit() {
        return storageClientApi.findAllStorageUnit();
    }

    @Override
    public StorageUnit addStorageUnit(StorageUnit storageUnit) {
        return storageClientApi.addStorageUnit(storageUnit);
    }

    @Override
    public StorageUnit updateStorageUnit(StorageUnit storageUnit, Long id) {
        return storageClientApi.updateStorageUnit(storageUnit, id);
    }

    @Override
    public boolean deleteStorageUnit(Long id) {
        return storageClientApi.deleteStorageUnit(id);
    }

    @Override
    public StorageUnit findStorageUnit(Long id) {
        return storageClientApi.findStorageUnit(id);
    }

    @Override
    public List<StorageUnit> findStorageUnitByAvailabilityId(Long id) {
        return storageClientApi.findStorageUnitByAvailabilityId(id);
    }
//    endregion storageUnit

    //    region unit

    @Override
    public List<Unit> findAllUnit() {
        return storageClientApi.findAllUnit();
    }

    @Override
    public Unit addUnit(Unit unit) {
        return storageClientApi.addUnit(unit);
    }

    @Override
    public Unit updateUnit(Unit unit, Long id) {
        return storageClientApi.updateUnit(unit, id);
    }

    @Override
    public boolean deleteUnit(Long id) {
        return storageClientApi.deleteUnit(id);
    }

    @Override
    public Unit findUnit(Long id) {
        return storageClientApi.findUnit(id);
    }

    @Override
    public List<Unit> findUnitByPositionId(Long id) {
        return storageClientApi.findUnitByPositionId(id);
    }
//    endregion unit

}
