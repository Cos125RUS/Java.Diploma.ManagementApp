package ru.steeldv.storage.service;

import ru.steeldv.storage.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Optional<Category> findById(Long id);
    Category update(Category category);
    boolean deleteById(Long id);
}
