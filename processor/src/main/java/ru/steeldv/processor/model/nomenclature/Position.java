package ru.steeldv.processor.model.nomenclature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {
    private Long id;
    private Long itemId;
    private Unit unit;
    private List<Availability> availabilities;
}
