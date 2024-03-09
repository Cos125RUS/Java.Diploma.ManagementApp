package ru.steeldv.front.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.steeldv.front.service.CatalogService;
import ru.steeldv.front.service.ClientsService;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final CatalogService catalogService;
    private final ClientsService clientsService;

    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        model.addAttribute("categories", catalogService.findAllCategories());
        return "catalog";
    }

    @GetMapping("/clients")
    public String clients(Model model) {
        model.addAttribute("clients", clientsService.findAll());
        return "clients";
    }
}
