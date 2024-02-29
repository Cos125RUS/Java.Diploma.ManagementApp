package ru.steeldv.storage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.storage.model.enums.UnitType;

import java.util.List;

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
    private List<Position> positions;
}
