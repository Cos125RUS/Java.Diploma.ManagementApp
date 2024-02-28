package ru.steeldv.storage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
    private Double thickness; // толщина
    private String size; // длина/габариты
    private String print; // отображение при печати
    @Column(nullable = false)
    private Double price;
    private Double cutting; // Стоимость резки
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true)
    private Set<Position> positions = new HashSet<>();

    public Item(Long id, Product product, Double thickness, String size, String print, Double price, Double cutting) {
        this.id = id;
        this.product = product;
        this.thickness = thickness;
        this.size = size;
        this.print = print;
        this.price = price;
        this.cutting = cutting;
    }
}
