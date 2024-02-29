package ru.steeldv.catalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.model.Category;
import ru.steeldv.storage.model.Product;
import ru.steeldv.storage.model.Subcategory;
import ru.steeldv.storage.repository.CategoryRepository;
import ru.steeldv.storage.repository.ProductRepository;
import ru.steeldv.storage.repository.SubcategoryRepository;
import ru.steeldv.storage.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        Category category = categoryRepository.findById(product.getCategory().getId()).get();
        product.setCategory(category);
        Subcategory subcategory = subcategoryRepository.findById(product.getSubcategory().getId()).get();
        product.setSubcategory(subcategory);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteById(Long id) {
        productRepository.deleteById(id);
        return true;
    }
}
