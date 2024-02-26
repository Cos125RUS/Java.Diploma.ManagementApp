package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.model.Category;
import ru.steeldv.storage.model.Subcategory;
import ru.steeldv.storage.repository.CategoryRepository;
import ru.steeldv.storage.repository.SubcategoryRepository;
import ru.steeldv.storage.service.SubcategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Subcategory> getAllSubcategory() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Subcategory addSubcategory(Subcategory subcategory) {
        Category category = categoryRepository.findById(subcategory.getCategoryId()).get();
        category.addSubcategory(subcategory);
        category = categoryRepository.save(category);
        List<Subcategory> subcategories = category.getSubcategories();
        return subcategories.stream()
                .filter(s -> s.getName().equals(subcategory.getName())).findFirst().get();
    }

    @Override
    public Optional<Subcategory> findById(Long id) {
        return subcategoryRepository.findById(id);
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
