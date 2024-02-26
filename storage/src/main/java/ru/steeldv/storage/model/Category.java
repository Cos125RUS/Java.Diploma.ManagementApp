package ru.steeldv.storage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Subcategory> subcategories;

    public boolean addSubcategory(Subcategory subcategory) {
        subcategories.add(subcategory);
        return true;
    }

    public boolean removeSubcategory(Subcategory subcategory) {
        subcategories.remove(subcategory);
        return true;
    }
}
