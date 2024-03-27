package ru.steeldv.catalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("category")
    private List<Subcategory> subcategories;

    public Category(String name) {
        this.name = name;
    }
}
