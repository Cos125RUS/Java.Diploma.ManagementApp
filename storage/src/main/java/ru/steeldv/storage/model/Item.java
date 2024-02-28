package ru.steeldv.storage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Enumerated
    @Column(nullable = false, name = "unit_type")
    private UnitType unitType; // единицы измененрия
    @Column(nullable = false)
    private Double units; // на остатках


}
