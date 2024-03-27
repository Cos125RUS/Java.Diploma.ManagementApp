package ru.steeldv.processor.model.nomenclature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Availability {
    private Long id;
    private Position position;
    private Storage storage;
    private StorageUnit unit;
}
