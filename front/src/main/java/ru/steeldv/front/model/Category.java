package ru.steeldv.front.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
    private Long id;
    private String name;
    private List<Subcategory> subcategories;

}
