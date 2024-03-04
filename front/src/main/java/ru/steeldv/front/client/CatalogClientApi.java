package ru.steeldv.front.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.steeldv.front.model.Category;

import java.util.List;

@FeignClient(name = "catalog")
public interface CatalogClientApi {

    @GetMapping("/category/findAll")
    public List<Category> findAllCategories();
}
