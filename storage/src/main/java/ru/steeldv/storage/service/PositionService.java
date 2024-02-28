package ru.steeldv.storage.service;

import ru.steeldv.storage.model.Position;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    List<Position> getAllPositions();
    Position addPosition(Position position);
    Optional<Position> findById(Long id);
    Position update(Position position);
    boolean deleteById(Long id);
}
