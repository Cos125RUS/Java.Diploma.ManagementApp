package ru.steeldv.catalog.service;

import ru.steeldv.catalog.entity.Subcategory;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {
    List<Subcategory> getAllSubcategories();
    Subcategory addSubcategory(Subcategory subcategory);
    Optional<Subcategory> findById(Long id);
    Optional<List<Subcategory>> findByCategoryId(Long id);
    Subcategory update(Subcategory subcategory, Long id);
    void deleteById(Long id);
}
