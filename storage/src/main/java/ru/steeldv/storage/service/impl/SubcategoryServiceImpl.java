package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.model.Subcategory;
import ru.steeldv.storage.repository.SubcategoryRepository;
import ru.steeldv.storage.service.SubcategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService {
    private final SubcategoryRepository repository;
    @Override
    public List<Subcategory> getAllSubcategory() {
        return repository.findAll();
    }

    @Override
    public Subcategory addSubcategory(Subcategory subcategory) {
        return repository.save(subcategory);
    }

    @Override
    public Optional<Subcategory> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Subcategory update(Subcategory subcategory) {
        return repository.save(subcategory);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }
}
