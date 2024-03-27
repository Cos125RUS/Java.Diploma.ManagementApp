package ru.steeldv.library.model.dto.nomenclature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.library.model.enums.UnitType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StorageUnit {
    private Long id;
    @JsonIgnoreProperties("units")
    private Availability availability;
    private UnitType unitType; // единицы измерения
    private Double quantity; // количество
}
