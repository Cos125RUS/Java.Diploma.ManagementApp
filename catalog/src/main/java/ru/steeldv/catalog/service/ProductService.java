package ru.steeldv.catalog.service;

import ru.steeldv.catalog.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();
    Product addProduct(Product product);
    Optional<Product> findById(Long id);
    Product update(Product product, Long id);
    boolean deleteById(Long id);
    Optional<List<Product>> findByCategoryId(Long id);

    Optional<List<Product>> findBySubcategoryId(Long id);
}
