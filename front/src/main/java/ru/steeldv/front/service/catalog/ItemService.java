package ru.steeldv.front.service.catalog;


import ru.steeldv.library.model.dto.catalog.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllItems();

    Item addItem(Item item);

    Item updateItem(Item item, Long id);

    void deleteItem(Long id);

    Item findItem(Long id);

    List<Item> findItemByProductId(Long id);
}
