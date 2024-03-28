package ru.steeldv.library.model.dto.nomenclature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Позиция в списке номенклатуры
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {
    private Long id;
    private Long itemId;
    private PositionList positionList; // идентификатор списка позиций
    private List<Unit> units; // количество в разных единицах измерения
    private List<Availability> availabilities;// соотношение количества товаров и складов (откуда сколько)
}
