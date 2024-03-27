package ru.steeldv.front.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.service.catalog.CategoryService;
import ru.steeldv.front.service.catalog.ItemService;
import ru.steeldv.front.service.catalog.ProductService;
import ru.steeldv.front.service.catalog.SubcategoryService;
import ru.steeldv.front.service.impl.CatalogServiceImpl;
import ru.steeldv.library.model.dto.catalog.Category;
import ru.steeldv.library.model.dto.catalog.Item;
import ru.steeldv.library.model.dto.catalog.Product;
import ru.steeldv.library.model.dto.catalog.Subcategory;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalog")
public class CatalogController {
    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;
    private final ProductService productService;
    private final ItemService itemService;

    @GetMapping("/category/findAll")
    public ResponseEntity<List<Category>> findAllCategories() {
        return new ResponseEntity<>(categoryService.findAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/category/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }

    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/subcategory/addSubcategory")
    public ResponseEntity<Subcategory> addSubcategory(@RequestBody Subcategory subcategory) {
        return new ResponseEntity<>(subcategoryService.addSubcategory(subcategory), HttpStatus.OK);
    }

    @DeleteMapping("/subcategory/delete/{id}")
    public ResponseEntity<Boolean> deleteSubcategory(@PathVariable Long id) {
        subcategoryService.deleteSubcategory(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/product/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/item/addItem")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.addItem(item), HttpStatus.OK);
    }

    @DeleteMapping("/item/delete/{id}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}
