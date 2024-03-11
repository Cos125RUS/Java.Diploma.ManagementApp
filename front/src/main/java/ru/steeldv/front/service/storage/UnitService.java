package ru.steeldv.front.service.storage;

import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.model.storage.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> findAllUnit();

    Unit addUnit(Unit unit);

    Unit updateUnit(Unit unit, Long id);

    boolean deleteUnit(Long id);

    Unit findUnit(Long id);

    List<Unit> findUnitByPositionId(Long id);
}
