package ru.steeldv.processor.model.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.processor.model.enums.UnitType;
import ru.steeldv.processor.model.storage.Position;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Unit {
    private Long id;
    private Position position;
    private UnitType unitType; // единицы измерения
    private Double quantity; // количество
}
