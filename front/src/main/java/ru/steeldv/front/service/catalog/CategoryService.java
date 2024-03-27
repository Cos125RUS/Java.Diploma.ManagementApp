package ru.steeldv.front.service.catalog;

import ru.steeldv.front.model.catalog.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();

    Category addCategory(Category category);

    Category updateCategory(Category category, Long id);

    void deleteCategory(Long id);
}
