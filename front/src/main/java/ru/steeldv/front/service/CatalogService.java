package ru.steeldv.front.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.front.client.CatalogClientApi;
import ru.steeldv.front.model.Category;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {
    private final CatalogClientApi catalogClientApi;

    public List<Category> findAllCategories() {
        return catalogClientApi.findAllCategories();
    }
}
