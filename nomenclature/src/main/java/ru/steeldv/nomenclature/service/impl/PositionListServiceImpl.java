package ru.steeldv.nomenclature.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.library.aspect.annotation.CallingLog;
import ru.steeldv.nomenclature.entity.PositionList;
import ru.steeldv.nomenclature.repository.PositionListRepository;
import ru.steeldv.nomenclature.service.PositionListService;

@Service
@RequiredArgsConstructor
public class PositionListServiceImpl implements PositionListService {
    private final PositionListRepository positionListRepository;

    @Override
    public PositionList findPositionListById(Long id) {
        return positionListRepository.findById(id).get();
    }

    @CallingLog
    @Override
    public PositionList addPositionList(PositionList positionList) {
        positionList.getPositions().forEach(position -> position.setPositionList(positionList));
        return positionListRepository.save(positionList);
    }
}
