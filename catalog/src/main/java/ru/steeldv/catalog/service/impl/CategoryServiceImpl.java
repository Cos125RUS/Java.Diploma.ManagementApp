package ru.steeldv.catalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.catalog.model.Category;
import ru.steeldv.catalog.repository.CategoryRepository;
import ru.steeldv.catalog.service.CategoryService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Category update(Category category, Long id) {
        findById(id).ifPresentOrElse(it -> category.setId(it.getId()), () -> {
            throw new NoSuchElementException();
        });
        return repository.save(category);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }
}
