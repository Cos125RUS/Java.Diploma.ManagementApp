package ru.steeldv.processor.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subcategory {
    private Long id;
    private String name;
    private Category category;
    private List<Product> products;
}
