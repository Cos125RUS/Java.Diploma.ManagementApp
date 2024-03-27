package ru.steeldv.storage.service;

import ru.steeldv.storage.entity.Unit;

import java.util.List;
import java.util.Optional;

public interface UnitService {
    List<Unit> getAllUnits();
    Unit addUnit(Unit unit);
    Optional<Unit> findById(Long id);
    Unit update(Unit unit);
    boolean deleteById(Long id);
    Unit findByPositionId(Long id);
}
