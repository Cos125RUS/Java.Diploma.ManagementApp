package ru.steeldv.front.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {


    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        return "catalog";
    }
}
