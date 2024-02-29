package ru.steeldv.catalog.service;

import ru.steeldv.catalog.model.Subcategory;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {
    List<Subcategory> getAllSubcategories();
    Subcategory addSubcategory(Subcategory subcategory);
    Optional<Subcategory> findById(Long id);
    Subcategory update(Subcategory subcategory);
    boolean deleteById(Long id);
}
