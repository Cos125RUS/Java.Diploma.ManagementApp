package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.model.Item;
import ru.steeldv.storage.model.Position;
import ru.steeldv.storage.repository.ItemRepository;
import ru.steeldv.storage.repository.PositionRepository;
import ru.steeldv.storage.service.PositionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final ItemRepository itemRepository;

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Position addPosition(Position position) {
        Item item = itemRepository.findById(position.getItem().getId()).get();
        position.setItem(item);
        return positionRepository.save(position);
    }

    @Override
    public Optional<Position> findById(Long id) {
        return positionRepository.findById(id);
    }

    @Override
    public Position update(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public boolean deleteById(Long id) {
        positionRepository.deleteById(id);
        return true;
    }
}
