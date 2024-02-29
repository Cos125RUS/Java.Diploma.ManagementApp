package ru.steeldv.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.catalog.model.Subcategory;
import ru.steeldv.catalog.service.SubcategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog/subcategory")
public class SubcategoryController {
    private final SubcategoryService subcategoryService;

    @GetMapping("/findAll")
    public List<Subcategory> findAll() {
        return subcategoryService.getAllSubcategories();
    }

    @PostMapping("/addSubcategory")
    public Subcategory addSubcategory(@RequestBody Subcategory subcategory) {
        return subcategoryService.addSubcategory(subcategory);
    }

    @PutMapping("/update/{id}")
    public Subcategory update(@RequestBody Subcategory subcategory, @PathVariable Long id) {
        Subcategory oldSubcategory = subcategoryService.findById(id).get();
        subcategory.setId(oldSubcategory.getId());
        return subcategoryService.update(subcategory);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return subcategoryService.deleteById(id);
    }

    @GetMapping("/findSubcategory/{id}")
    public Subcategory findSubcategory(@PathVariable Long id) {
        return subcategoryService.findById(id).get();
    }

    @GetMapping("/findByCategoryId/{id}")
    public List<Subcategory> findByCategoryId(@PathVariable Long id) {
        return subcategoryService.findByCategoryId(id).get();
    }

}
