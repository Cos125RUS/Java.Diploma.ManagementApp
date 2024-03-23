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
import java.util.NoSuchElementException;
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
        categoryRepository.findById(product.getCategory().getId())
                .ifPresentOrElse(product::setCategory, NoSuchElementException::new);
        subcategoryRepository.findById(product.getSubcategory().getId())
                .ifPresentOrElse(product::setSubcategory, NoSuchElementException::new);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Product product, Long id) {
        findById(id).ifPresentOrElse(it -> product.setId(it.getId()), NoSuchElementException::new);
        return productRepository.save(product);
    }

    @Override
    public boolean deleteById(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<List<Product>> findByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    @Override
    public Optional<List<Product>> findBySubcategoryId(Long id) {
        return productRepository.findBySubcategoryId(id);
    }
}
