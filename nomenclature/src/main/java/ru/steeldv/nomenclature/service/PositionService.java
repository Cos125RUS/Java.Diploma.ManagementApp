package ru.steeldv.nomenclature.service;

import ru.steeldv.nomenclature.model.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> findPositionByListId(Long id);

}
