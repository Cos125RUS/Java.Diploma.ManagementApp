package ru.steeldv.catalog.model;

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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("products")
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
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
