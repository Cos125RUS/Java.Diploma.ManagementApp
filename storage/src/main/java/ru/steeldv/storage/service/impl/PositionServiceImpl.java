package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.entity.Position;
import ru.steeldv.storage.repository.PositionRepository;
import ru.steeldv.storage.service.PositionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public Position findByItemId(Long itemId) {
        return positionRepository.findByItemId(itemId).get();
    }

    @Override
    public Position addPosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public Position findById(Long id) {
        return positionRepository.findById(id).get();
    }

    @Override
    public Position update(Position position, Long id) {
        Position oldPosition = positionRepository.findById(id).get();
        position.setId(oldPosition.getId());
        return positionRepository.save(position);
    }

    @Override
    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
