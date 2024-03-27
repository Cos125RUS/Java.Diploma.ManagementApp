package ru.steeldv.nomenclature.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.nomenclature.model.entity.Position;
import ru.steeldv.nomenclature.repository.PositionRepository;
import ru.steeldv.nomenclature.service.PositionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public List<Position> findPositionByListId(Long id) {
        return positionRepository.findByListId(id).get();
    }
}
