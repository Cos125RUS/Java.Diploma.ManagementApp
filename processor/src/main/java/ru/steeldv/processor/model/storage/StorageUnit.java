package ru.steeldv.processor.model.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.processor.model.enums.UnitType;
import ru.steeldv.processor.model.storage.Availability;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StorageUnit {
    private Long id;
    private Availability availability;
    private UnitType unitType; // единицы измерения
    private Double quantity; // количество
}
