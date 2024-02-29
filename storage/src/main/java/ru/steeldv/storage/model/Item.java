package ru.steeldv.storage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.storage.model.enums.UnitType;

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
    private String print; // отображение при печати
    private Double thickness; // толщина
    private String size; // длина/габариты
    private Double weight; // вес единицы товара
    @Column(nullable = false, name = "base_unit_type")
    private UnitType baseUnitType; // базовая единица товара
    @Column(nullable = false, name = "unit_price")
    private Double unitPrice; // цена за единицу товара
    @Column(name = "cutting_price")
    private Double cuttingPrise; // Стоимость резки
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("item")
    private List<Position> positions;
}
