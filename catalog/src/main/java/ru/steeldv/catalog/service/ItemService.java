package ru.steeldv.catalog.service;

import ru.steeldv.catalog.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAllItems();
    Item addItem(Item item);
    Optional<Item> findById(Long id);
    Item update(Item item);
    boolean deleteById(Long id);
    Optional<List<Item>> findByProductId(Long id);
}
