package ru.steeldv.library.model.dto.nomenclature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Список позиций товара
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PositionList {
    private Long id;
    private List<Position> positions; // позиции в списке

    public PositionList(List<Position> positions) {
        this.positions = positions;
    }
}
