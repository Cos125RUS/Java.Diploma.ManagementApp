package ru.steeldv.front.service.storage;

import org.springframework.web.bind.annotation.*;
import ru.steeldv.library.model.dto.nomenclature.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> findAllUnit();

    Unit addUnit(Unit unit);

    Unit updateUnit(Unit unit, Long id);

    boolean deleteUnit(Long id);

    Unit findUnit(Long id);

    Unit findUnitByPositionId(Long id);
}
