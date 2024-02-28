package ru.steeldv.storage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.steeldv.storage.repository.CategoryRepository;

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
    private Category category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategory", orphanRemoval = true)
    private List<Product> products;

    public Subcategory(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
