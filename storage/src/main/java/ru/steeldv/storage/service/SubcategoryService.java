package ru.steeldv.storage.service;

import ru.steeldv.storage.model.Subcategory;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {
    List<Subcategory> getAllSubcategories();
    Subcategory addSubcategory(Subcategory subcategory);
    Optional<Subcategory> findById(Long id);
    Subcategory update(Subcategory subcategory);
    boolean deleteById(Long id);
}
