package ru.steeldv.documents.service.product.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.documents.model.entity.product.Position;
import ru.steeldv.documents.repository.product.PositionRepository;
import ru.steeldv.documents.service.product.PositionService;

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
