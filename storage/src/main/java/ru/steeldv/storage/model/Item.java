package ru.steeldv.storage.model;

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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("items")
    private Product product;
    private Double thickness; // толщина
    private String size; // длина/габариты
    private String print; // отображение при печати
    @Column(nullable = false)
    private Double price;
    private Double cutting; // Стоимость резки
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("item")
    private List<Position> positions;
}
