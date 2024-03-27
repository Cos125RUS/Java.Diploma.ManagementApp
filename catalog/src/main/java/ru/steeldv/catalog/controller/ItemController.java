package ru.steeldv.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.catalog.entity.Item;
import ru.steeldv.catalog.service.ItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog/item")
public class ItemController {
    private final ItemService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Item>> findAll() {
        return new ResponseEntity<>(service.getAllItems(), HttpStatus.OK);
    }

    @PostMapping("/addItem")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return new ResponseEntity<>(service.addItem(item), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> update(@RequestBody Item item, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(item, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findItem/{id}")
    public ResponseEntity<Item> findItem(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/findByProductId/{id}")
    public ResponseEntity<List<Item>> findByProductId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findByProductId(id).get(), HttpStatus.OK);
    }
}
