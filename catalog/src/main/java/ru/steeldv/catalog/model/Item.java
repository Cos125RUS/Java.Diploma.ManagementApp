package ru.steeldv.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.catalog.model.enums.UnitType;

import java.math.BigInteger;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("items")
    private Product product;
    private String print; // отображение при печати
    private Double thickness; // толщина
    private String size; // длина/габариты
    private Double weight; // вес единицы товара
    @Enumerated
    @Column(nullable = false, name = "base_unit_type")
    private UnitType baseUnitType; // базовая единица товара
    @Column(nullable = false, name = "unit_price")
    private Integer unitPrice; // цена за единицу товара
    @Column(name = "cutting_price")
    private Integer cuttingPrise; // Стоимость резки

    public Item(Product product, String print, Double thickness, String size, Double weight,
                UnitType baseUnitType, Integer unitPrice, Integer cuttingPrise) {
        this.product = product;
        this.print = print;
        this.thickness = thickness;
        this.size = size;
        this.weight = weight;
        this.baseUnitType = baseUnitType;
        this.unitPrice = unitPrice;
        this.cuttingPrise = cuttingPrise;
    }
}
