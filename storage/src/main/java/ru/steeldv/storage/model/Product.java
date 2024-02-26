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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "category_id"))
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "subcategory_id"))
    private Subcategory subcategory;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
}
