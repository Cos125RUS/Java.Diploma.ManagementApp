package ru.steeldv.front.service.catalog;

import ru.steeldv.front.model.catalog.Subcategory;

import java.util.List;

public interface SubcategoryService {
    Subcategory addSubcategory(Subcategory subcategory);

    Subcategory updateSubcategory(Subcategory subcategory, Long id);

    void deleteSubcategory(Long id);

    List<Subcategory> findSubcategoryByCategoryId(Long id);
}
