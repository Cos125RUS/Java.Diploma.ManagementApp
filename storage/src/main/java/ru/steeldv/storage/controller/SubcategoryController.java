package ru.steeldv.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.model.Subcategory;
import ru.steeldv.storage.service.SubcategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/subcategory")
public class SubcategoryController {
    private final SubcategoryService service;

    @GetMapping("/findAll")
    public List<Subcategory> findAll() {
        return service.getAllSubcategory();
    }

    @PostMapping("/addSubcategory")
    public Subcategory addSubcategory(@RequestBody Subcategory subcategory) {
        return service.addSubcategory(subcategory);
    }

    @PutMapping("/update/{id}")
    public Subcategory update(@RequestBody Subcategory subcategory, @PathVariable Long id) {
        Subcategory oldSubcategory = service.findById(id).get();
        subcategory.setId(oldSubcategory.getId());
        return service.update(subcategory);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/findSubcategory/{id}")
    public Subcategory findSubcategory(@PathVariable Long id) {
        return service.findById(id).get();
    }
}
