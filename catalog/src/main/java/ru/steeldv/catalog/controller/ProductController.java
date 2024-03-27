package ru.steeldv.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.catalog.entity.Product;
import ru.steeldv.catalog.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog/product")
public class ProductController {
    private final ProductService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(service.getAllProduct(),HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(service.addProduct(product), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(product, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findProduct/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/findByCategoryId/{id}")
    public ResponseEntity<List<Product>> findByCategoryId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findByCategoryId(id).get(), HttpStatus.OK);
    }

    @GetMapping("/findBySubcategoryId/{id}")
    public ResponseEntity<List<Product>> findBySubcategoryId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findBySubcategoryId(id).get(), HttpStatus.OK);
    }
}
