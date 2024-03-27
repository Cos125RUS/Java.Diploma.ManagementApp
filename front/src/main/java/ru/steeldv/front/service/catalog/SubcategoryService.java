package ru.steeldv.front.service.catalog;


import ru.steeldv.library.model.dto.catalog.Subcategory;

import java.util.List;

public interface SubcategoryService {
    Subcategory addSubcategory(Subcategory subcategory);

    Subcategory updateSubcategory(Subcategory subcategory, Long id);

    void deleteSubcategory(Long id);

    List<Subcategory> findSubcategoryByCategoryId(Long id);
}
