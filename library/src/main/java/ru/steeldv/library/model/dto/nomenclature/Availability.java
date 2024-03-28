package ru.steeldv.library.model.dto.nomenclature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Соотношение товара со складом (сколько указанного товара на каком складе)
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Availability {
    private Long id;
    @ToString.Exclude
    private Position position;
    @ToString.Exclude
    private Storage storage;
    private List<StorageUnit> units; // соотношение единиц измерения и количества товара на конкретном складе
}
