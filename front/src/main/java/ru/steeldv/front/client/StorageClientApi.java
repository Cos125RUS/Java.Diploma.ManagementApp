package ru.steeldv.front.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.model.storage.*;

import java.util.List;

@FeignClient(name = "storage")
public interface StorageClientApi {
    //    region storage
    @GetMapping("storage/findAll")
    List<Storage> findAllStorage();

    @PostMapping("storage/addStorage")
    Storage addStorage(@RequestBody Storage storage);

    @PutMapping("storage/update/{id}")
    Storage updateStorage(@RequestBody Storage storage, @PathVariable Long id);

    @DeleteMapping("storage/delete/{id}")
    boolean deleteStorage(@PathVariable Long id);

    @GetMapping("storage/findStorage/{id}")
    Storage findStorage(@PathVariable Long id);
    //    endregion storage

    //    region availability
    @GetMapping("availability/findAll")
    List<Availability> findAllAvailability();

    @PostMapping("availability/addAvailability")
    Availability addAvailability(@RequestBody Availability availability);

    @PutMapping("availability/update/{id}")
    Availability updateAvailability(@RequestBody Availability availability, @PathVariable Long id);

    @DeleteMapping("availability/delete/{id}")
    boolean deleteAvailability(@PathVariable Long id);

    @GetMapping("availability/findAvailability/{id}")
    Availability findAvailability(@PathVariable Long id);

    @GetMapping("availability/findByPositionId/{id}")
    List<Availability> findAvailabilityByPositionId(@PathVariable Long id);
//    endregion availability

    //    region position
    @GetMapping("position/findByItemId/{itemId}")
    List<Position> findPositionByItemId(@PathVariable Long itemId);

    @PostMapping("position/addPosition")
    Position addPosition(@RequestBody Position position);

    @PutMapping("position/update/{id}")
    Position updatePosition(@RequestBody Position position, @PathVariable Long id);

    @DeleteMapping("position/delete/{id}")
    boolean deletePosition(@PathVariable Long id);

    @GetMapping("position/findPosition/{id}")
    Position findPosition(@PathVariable Long id);
//    endregion position

    //    region storageUnit
    @GetMapping("storageUnit/findAll")
    List<StorageUnit> findAllStorageUnit();

    @PostMapping("storageUnit/addStorageUnit")
    StorageUnit addStorageUnit(@RequestBody StorageUnit storageUnit);

    @PutMapping("storageUnit/update/{id}")
    StorageUnit updateStorageUnit(@RequestBody StorageUnit storageUnit, @PathVariable Long id);

    @DeleteMapping("storageUnit/delete/{id}")
    boolean deleteStorageUnit(@PathVariable Long id);

    @GetMapping("storageUnit/findStorageUnit/{id}")
    StorageUnit findStorageUnit(@PathVariable Long id);

    @GetMapping("storageUnit/findByAvailabilityId/{id}")
    List<StorageUnit> findStorageUnitByAvailabilityId(@PathVariable Long id);
//    endregion storageUnit

    //    region unit
    @GetMapping("unit/findAll")
    List<Unit> findAllUnit();

    @PostMapping("unit/addUnit")
    Unit addUnit(@RequestBody Unit unit);

    @PutMapping("unit/update/{id}")
    Unit updateUnit(@RequestBody Unit unit, @PathVariable Long id);

    @DeleteMapping("unit/delete/{id}")
    boolean deleteUnit(@PathVariable Long id);

    @GetMapping("unit/findUnit/{id}")
    Unit findUnit(@PathVariable Long id);

    @GetMapping("unit/findByPositionId/{id}")
    List<Unit> findUnitByPositionId(@PathVariable Long id);
//    endregion unit
}
