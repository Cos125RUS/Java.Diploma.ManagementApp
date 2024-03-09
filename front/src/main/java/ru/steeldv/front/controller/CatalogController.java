package ru.steeldv.front.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.model.catalog.Category;
import ru.steeldv.front.model.catalog.Item;
import ru.steeldv.front.model.catalog.Product;
import ru.steeldv.front.model.catalog.Subcategory;
import ru.steeldv.front.service.CatalogService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalog")
public class CatalogController {
    private final CatalogService catalogService;

    @GetMapping("/category/findAll")
    public ResponseEntity<List<Category>> findAllCategories() {
        return new ResponseEntity<>(catalogService.findAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/category/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(catalogService.addCategory(category), HttpStatus.OK);
    }

    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable Long id) {
        return new ResponseEntity<>(catalogService.deleteCategory(id), HttpStatus.OK);
    }

    @PostMapping("/subcategory/addSubcategory")
    public ResponseEntity<Subcategory> addSubcategory(@RequestBody Subcategory subcategory) {
        return new ResponseEntity<>(catalogService.addSubcategory(subcategory), HttpStatus.OK);
    }

    @DeleteMapping("/subcategory/delete/{id}")
    public ResponseEntity<Boolean> deleteSubcategory(@PathVariable Long id) {
        return new ResponseEntity<>(catalogService.deleteSubcategory(id), HttpStatus.OK);
    }

    @PostMapping("/product/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(catalogService.addProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(catalogService.deleteProduct(id), HttpStatus.OK);
    }

    @PostMapping("/item/addItem")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return new ResponseEntity<>(catalogService.addItem(item), HttpStatus.OK);
    }

    @DeleteMapping("/item/delete/{id}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable Long id) {
        return new ResponseEntity<>(catalogService.deleteItem(id), HttpStatus.OK);
    }
}
