package ru.steeldv.documents.service.product;

import ru.steeldv.documents.model.entity.product.Position;

import java.util.List;

public interface PositionService {
    List<Position> findPositionByListId(Long id);
}
