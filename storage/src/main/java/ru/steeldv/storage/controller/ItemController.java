package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.model.Item;
import ru.steeldv.storage.service.ItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/item")
public class ItemController {
    private final ItemService service;

    @GetMapping("/findAll")
    public List<Item> findAll() {
        return service.getAllItem();
    }

    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item) {
        return service.addItem(item);
    }

    @PutMapping("/update/{id}")
    public Item update(@RequestBody Item item, @PathVariable Long id) {
        Item oldItem = service.findById(id).get();
        item.setId(oldItem.getId());
        return service.update(item);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/findItem/{id}")
    public Item findItem(@PathVariable Long id) {
        return service.findById(id).get();
    }
}
