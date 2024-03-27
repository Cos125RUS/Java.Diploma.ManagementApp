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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("products")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @JsonIgnoreProperties("products")
    private Subcategory subcategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("product")
    private List<Item> items;

    public Product(String name, Category category, Subcategory subcategory) {
        this.name = name;
        this.category = category;
        this.subcategory = subcategory;
    }
}
