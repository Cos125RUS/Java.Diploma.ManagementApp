package ru.steeldv.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.storage.model.Product;
import ru.steeldv.storage.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage/product")
public class ProductController {
    private final ProductService service;

    @GetMapping("/findAll")
    public List<Product> findAll() {
        return service.getAllProduct();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        Product oldProduct = service.findById(id).get();
        product.setId(oldProduct.getId());
        return service.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/findProduct/{id}")
    public Product findProduct(@PathVariable Long id) {
        return service.findById(id).get();
    }
}
