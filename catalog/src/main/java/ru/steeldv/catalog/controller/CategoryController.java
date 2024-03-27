package ru.steeldv.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.catalog.entity.Category;
import ru.steeldv.catalog.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog/category")
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Category>> findAll() {
        return new ResponseEntity<>(service.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(service.addCategory(category), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(category, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findCategory/{id}")
    public ResponseEntity<Category> findCategory(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id).get(), HttpStatus.OK);
    }
}
