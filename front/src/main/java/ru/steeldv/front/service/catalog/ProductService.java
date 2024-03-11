package ru.steeldv.front.service.catalog;

import ru.steeldv.front.model.catalog.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    Product updateProduct(Product product, Long id);

    boolean deleteProduct(Long id);

    List<Product> findProductByCategoryId(Long id);

    List<Product> findProductBySubcategoryId(Long id);
}
