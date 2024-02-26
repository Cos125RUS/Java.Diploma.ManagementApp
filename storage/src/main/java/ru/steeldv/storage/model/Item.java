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
    @Column(nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "product_id"))
    private Product product;
    @Column(nullable = false)
    private String thickness;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private Double price;
    @Enumerated
    @Column(nullable = false, name = "unit_type")
    private UnitType unitType;
    @Column(nullable = false)
    private Double units;
}
