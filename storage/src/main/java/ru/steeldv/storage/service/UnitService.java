package ru.steeldv.storage.service;

import ru.steeldv.storage.model.Position;
import ru.steeldv.storage.model.Unit;

import java.util.List;
import java.util.Optional;

public interface UnitService {
    List<Unit> getAllUnits();
    Unit addUnit(Unit unit);
    Optional<Unit> findById(Long id);
    Unit update(Unit unit);
    boolean deleteById(Long id);
    List<Position> findByPositionId(Long id);
}
