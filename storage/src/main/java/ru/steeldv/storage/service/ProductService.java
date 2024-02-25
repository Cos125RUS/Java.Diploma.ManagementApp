package ru.steeldv.storage.service;

import ru.steeldv.storage.model.Category;
import ru.steeldv.storage.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();
    Product addProduct(Product product);
    Optional<Product> findById(Long id);
    Product update(Product product);
    boolean deleteById(Long id);
}
