package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.model.Category;
import ru.steeldv.storage.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/category")
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/findAll")
    public List<Category> findAll() {
        return service.getAllCategory();
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {
        return service.addCategory(category);
    }

    @PutMapping("/update/{id}")
    public Category update(@RequestBody Category category, @PathVariable Long id) {
        Category oldCategory = service.findById(id).get();
        category.setId(oldCategory.getId());
        return service.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/findCategory/{id}")
    public Category findCategory(@PathVariable Long id) {
        return service.findById(id).get();
    }
}
