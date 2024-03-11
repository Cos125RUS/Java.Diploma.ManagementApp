package ru.steeldv.front.service.catalog;

import ru.steeldv.front.model.catalog.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllItems();

    Item addItem(Item item);

    Item updateItem(Item item, Long id);

    boolean deleteItem(Long id);

    Item findItem(Long id);

    List<Item> findItemByProductId(Long id);
}
