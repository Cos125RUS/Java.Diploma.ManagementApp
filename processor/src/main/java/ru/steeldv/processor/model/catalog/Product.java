package ru.steeldv.processor.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.processor.model.catalog.Category;
import ru.steeldv.processor.model.catalog.Subcategory;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private String name;
    private Category category;
    private Subcategory subcategory;
    private List<Item> items;
}
