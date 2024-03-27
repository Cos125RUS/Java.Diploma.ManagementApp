package ru.steeldv.front.service.catalog;


import ru.steeldv.library.model.dto.catalog.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    Product updateProduct(Product product, Long id);

    void deleteProduct(Long id);

    List<Product> findProductByCategoryId(Long id);

    List<Product> findProductBySubcategoryId(Long id);
}
