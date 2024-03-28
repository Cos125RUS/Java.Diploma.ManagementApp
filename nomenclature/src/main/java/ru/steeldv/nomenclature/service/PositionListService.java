package ru.steeldv.nomenclature.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.library.aspect.annotation.CallingLog;
//import ru.steeldv.library.service.CRUDServiceImpl;
import ru.steeldv.library.service.ManagementService;
import ru.steeldv.nomenclature.entity.PositionList;
import ru.steeldv.nomenclature.repository.PositionListRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionListService implements ManagementService<PositionList> {
    private final PositionListRepository positionListRepository;

    @Override
    public List<PositionList> findAll() {
        return positionListRepository.findAll();
    }

    @CallingLog
    @Override
    public PositionList add(PositionList positionList) {
        positionList.getPositions().forEach(position -> position.setPositionList(positionList));
        return positionListRepository.save(positionList);
    }

    @Override
    public PositionList findById(Long id) {
        return positionListRepository.findById(id).get();
    }

    @CallingLog
    public PositionList update(PositionList positionList) {
        positionList.getPositions().forEach(position -> position.setPositionList(positionList));
        return positionListRepository.save(positionList);
    }

    @Override
    public void deleteById(Long id) {
        positionListRepository.deleteById(id);
    }
}
