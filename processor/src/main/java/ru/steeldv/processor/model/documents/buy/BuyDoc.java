package ru.steeldv.processor.model.documents.buy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.processor.model.documents.storage.ComingDoc;
import ru.steeldv.processor.model.enums.DocType;
import ru.steeldv.processor.model.nomenclature.Position;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Документ о покупке
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyDoc {
    private Long id;
    private DocType type;
    private String number;
    private LocalDate date;
    private LocalTime time;
    private LocalDateTime lastChange;
    private boolean passed; //проведён / не проведён
    private Long salesman; // id продавца
    private Long manager; // id менеджера
    private Long transportation; //id транспортировки
    private Long positions; // id списка позиций
    private ComingDoc comingDoc; // документ поступления на склад
    private List<Position> positionList; // список позиций, получаемый с фронта
//    TODO: Денежные операции (Расчётный счёт / поступление средств / счёт-фактура и т.д.)

}
