package ru.steeldv.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Subcategory>> findAll() {
        return new ResponseEntity<>(subcategoryService.getAllSubcategories(), HttpStatus.OK);
    }

    @PostMapping("/addSubcategory")
    public ResponseEntity<Subcategory> addSubcategory(@RequestBody Subcategory subcategory) {
        return new ResponseEntity<>(subcategoryService.addSubcategory(subcategory), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Subcategory> update(@RequestBody Subcategory subcategory, @PathVariable Long id) {
        Subcategory oldSubcategory = subcategoryService.findById(id).get();
        subcategory.setId(oldSubcategory.getId());
        return new ResponseEntity<>(subcategoryService.update(subcategory), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(subcategoryService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping("/findSubcategory/{id}")
    public ResponseEntity<Subcategory> findSubcategory(@PathVariable Long id) {
        return new ResponseEntity<>(subcategoryService.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/findByCategoryId/{id}")
    public ResponseEntity<List<Subcategory>> findByCategoryId(@PathVariable Long id) {
        return new ResponseEntity<>(subcategoryService.findByCategoryId(id).get(), HttpStatus.OK);
    }

}
