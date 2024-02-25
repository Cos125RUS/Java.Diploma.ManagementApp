package ru.steeldv.storage.service;

import ru.steeldv.storage.model.Item;
import ru.steeldv.storage.model.Product;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAllItem();
    Item addItem(Item item);
    Optional<Item> findById(Long id);
    Item update(Item item);
    boolean deleteById(Long id);
}
