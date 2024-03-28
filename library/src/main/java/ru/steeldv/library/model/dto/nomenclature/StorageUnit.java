package ru.steeldv.library.model.dto.nomenclature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.steeldv.library.model.enums.UnitType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StorageUnit {
    private Long id;
    @ToString.Exclude
    private Availability availability;
    private UnitType unitType; // единицы измерения
    private Double quantity; // количество
}
