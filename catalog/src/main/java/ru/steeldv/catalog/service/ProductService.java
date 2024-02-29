package ru.steeldv.catalog.service;

import ru.steeldv.catalog.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();
    Product addProduct(Product product);
    Optional<Product> findById(Long id);
    Product update(Product product);
    boolean deleteById(Long id);
}
