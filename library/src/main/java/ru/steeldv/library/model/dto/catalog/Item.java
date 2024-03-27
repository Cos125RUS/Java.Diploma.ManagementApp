package ru.steeldv.library.model.dto.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.library.model.enums.UnitType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private Long id;
    private Product product;
    private String print; // отображение при печати
    private Double thickness; // толщина
    private String size; // длина/габариты
    private Double weight; // вес единицы товара
    private UnitType baseUnitType; // базовая единица товара
    private Double unitPrice; // цена за единицу товара
    private Double cuttingPrise; // Стоимость резки
}
