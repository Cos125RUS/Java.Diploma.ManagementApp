package ru.steeldv.nomenclature.service;

import org.springframework.stereotype.Service;
import ru.steeldv.library.aspect.annotation.CallingLog;
import ru.steeldv.library.service.CRUDServiceImpl;
import ru.steeldv.nomenclature.entity.PositionList;
import ru.steeldv.nomenclature.repository.PositionListRepository;

@Service
public class PositionListService extends CRUDServiceImpl<PositionList, PositionListRepository> {

    @CallingLog
    @Override
    public PositionList add(PositionList positionList) {
        positionList.getPositions().forEach(position -> position.setPositionList(positionList));
        return repo.save(positionList);
    }

    @CallingLog
    public PositionList update(PositionList positionList) {
        positionList.getPositions().forEach(position -> position.setPositionList(positionList));
        return repo.save(positionList);
    }
}
