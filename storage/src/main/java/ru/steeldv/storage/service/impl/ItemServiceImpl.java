package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.model.Item;
import ru.steeldv.storage.repository.ItemRepository;
import ru.steeldv.storage.service.ItemService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    @Override
    public List<Item> getAllItem() {
        return repository.findAll();
    }

    @Override
    public Item addItem(Item item) {
        return repository.save(item);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Item update(Item item) {
        return repository.save(item);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }
}
