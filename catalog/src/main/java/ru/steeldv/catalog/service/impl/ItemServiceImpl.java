package ru.steeldv.catalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.catalog.entity.Item;
import ru.steeldv.catalog.repository.ItemRepository;
import ru.steeldv.catalog.repository.ProductRepository;
import ru.steeldv.catalog.service.ItemService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item addItem(Item item) {
        productRepository.findById(item.getProduct().getId())
                .ifPresentOrElse(item::setProduct, () -> {
                    throw new NoSuchElementException();
                });
        return itemRepository.save(item);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item update(Item item, Long id) {
        findById(id).ifPresentOrElse(it -> item.setId(it.getId()), () -> {
            throw new NoSuchElementException();
        });
        return itemRepository.save(item);
    }

    @Override
    public boolean deleteById(Long id) {
        itemRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<List<Item>> findByProductId(Long id) {
        return itemRepository.findByProductId(id);
    }
}
