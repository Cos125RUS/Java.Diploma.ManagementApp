package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.model.dto.Position;
import ru.steeldv.storage.model.dto.Unit;
import ru.steeldv.storage.repository.PositionRepository;
import ru.steeldv.storage.repository.UnitRepository;
import ru.steeldv.storage.service.UnitService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;
    private final PositionRepository positionRepository;

    @Override
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    public Unit addUnit(Unit unit) {
        Position position = positionRepository.findById(unit.getPosition().getId()).get();
        unit.setPosition(position);
        return unitRepository.save(unit);
    }

    @Override
    public Optional<Unit> findById(Long id) {
        return unitRepository.findById(id);
    }

    @Override
    public Unit update(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public boolean deleteById(Long id) {
        unitRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Unit> findByPositionId(Long id) {
        return unitRepository.findByPositionId(id).get();
    }
}
