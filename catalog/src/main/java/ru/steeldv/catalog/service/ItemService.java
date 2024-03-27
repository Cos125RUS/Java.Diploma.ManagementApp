package ru.steeldv.catalog.service;

import ru.steeldv.catalog.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAllItems();
    Item addItem(Item item);
    Optional<Item> findById(Long id);
    Item update(Item item, Long id);
    boolean deleteById(Long id);
    Optional<List<Item>> findByProductId(Long id);
}
