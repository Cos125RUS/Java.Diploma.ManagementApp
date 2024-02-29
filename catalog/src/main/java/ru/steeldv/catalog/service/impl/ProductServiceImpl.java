package ru.steeldv.catalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.catalog.model.Category;
import ru.steeldv.catalog.model.Product;
import ru.steeldv.catalog.model.Subcategory;
import ru.steeldv.catalog.repository.CategoryRepository;
import ru.steeldv.catalog.repository.ProductRepository;
import ru.steeldv.catalog.repository.SubcategoryRepository;
import ru.steeldv.catalog.service.ProductService;

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
