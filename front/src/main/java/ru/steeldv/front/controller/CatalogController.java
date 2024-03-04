package ru.steeldv.front.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.steeldv.front.model.Category;
import ru.steeldv.front.service.CatalogService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalog")
public class CatalogController {
    private final CatalogService catalogService;

    @GetMapping("/category/findAll")
    public List<Category> findAllCategories() {
        return catalogService.findAllCategories();
    }
}
