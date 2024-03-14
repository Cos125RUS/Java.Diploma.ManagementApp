package ru.steeldv.front.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.steeldv.front.service.catalog.CategoryService;
import ru.steeldv.front.service.impl.CatalogServiceImpl;
import ru.steeldv.front.service.ClientsService;
import ru.steeldv.front.service.impl.StorageServiceImpl;
import ru.steeldv.front.service.storage.StorageService;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final CategoryService categoryService;
    private final ClientsService clientsService;
    private final StorageService storageService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "Главная");
        return "index";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        model.addAttribute("title", "Каталог");
        model.addAttribute("categories", categoryService.findAllCategories());
        return "catalog";
    }

    @GetMapping("/clients")
    public String clients(Model model) {
        model.addAttribute("title", "Контрагенты");
        model.addAttribute("clients", clientsService.findAll());
        return "clients";
    }

    @GetMapping("/storage")
    public String storage(Model model) {
        model.addAttribute("title", "Склады");
        model.addAttribute("storages", storageService.findAllStorage());
        return "storage";
    }

    @GetMapping("/documents")
    public String documents(Model model) {
        model.addAttribute("title", "Документы");
        return "documents";
    }
}
