package ru.steeldv.library.model.dto.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subcategory {
    private Long id;
    private String name;
    @ToString.Exclude
    private Category category;
    private List<Product> products;
}
