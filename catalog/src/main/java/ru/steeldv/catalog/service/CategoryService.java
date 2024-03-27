package ru.steeldv.catalog.service;

import ru.steeldv.catalog.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Optional<Category> findById(Long id);
    Category update(Category category, Long id);
    boolean deleteById(Long id);
}
