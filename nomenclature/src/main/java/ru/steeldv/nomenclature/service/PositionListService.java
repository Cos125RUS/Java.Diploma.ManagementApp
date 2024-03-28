package ru.steeldv.nomenclature.service;

import ru.steeldv.nomenclature.entity.PositionList;

public interface PositionListService {
    PositionList findPositionListById(Long id);

    PositionList addPositionList(PositionList positionList);
}
