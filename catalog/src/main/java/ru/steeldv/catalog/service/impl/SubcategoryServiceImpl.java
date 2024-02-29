package ru.steeldv.catalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.catalog.model.Category;
import ru.steeldv.catalog.model.Subcategory;
import ru.steeldv.catalog.repository.CategoryRepository;
import ru.steeldv.catalog.repository.SubcategoryRepository;
import ru.steeldv.catalog.service.SubcategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Subcategory addSubcategory(Subcategory subcategory) {
        Category category = categoryRepository.findById(subcategory.getCategory().getId()).get();
        subcategory.setCategory(category);
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public Optional<Subcategory> findById(Long id) {
        return subcategoryRepository.findById(id);
    }

    @Override
    public Optional<List<Subcategory>> findByCategoryId(Long id) {
        return subcategoryRepository.findByCategoryId(id);
    }

    @Override
    public Subcategory update(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public boolean deleteById(Long id) {
        subcategoryRepository.deleteById(id);
        return true;
    }
}
