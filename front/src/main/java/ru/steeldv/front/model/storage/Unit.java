package ru.steeldv.front.model.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.front.model.enums.UnitType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Unit {
    private Long id;
    private Position position;
    private UnitType unitType; // единицы измерения
    private Double quantity; // количество
}
