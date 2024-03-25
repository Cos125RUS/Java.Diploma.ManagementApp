package ru.steeldv.processor.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.processor.model.catalog.Subcategory;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
    private Long id;
    private String name;
    private List<Subcategory> subcategories;

}
