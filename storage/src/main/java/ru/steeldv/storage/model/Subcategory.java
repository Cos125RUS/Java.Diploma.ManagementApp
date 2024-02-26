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
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinTable(joinColumns = @JoinColumn(name = "category_id"))
    @Column(name = "category_id", nullable = false)
    private Long categoryId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    public Subcategory(String name, Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }
}
