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
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("subcategories")
    private Category category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategory", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"subcategory", "category"})
    private List<Product> products;
}
