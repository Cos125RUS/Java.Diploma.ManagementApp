package ru.steeldv.library.model.dto.documents.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.library.model.dto.documents.buy.BuyDoc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComingDoc {
    private Long id;
    private String number; // Номер документа в журнале учёта
    private LocalDate date;
    private LocalTime time;
    private LocalDateTime lastChange;
    private boolean passed; //проведён / не проведён
    private Long salesman; // id продавца
    private Long manager; // id менеджера
    private Long transportation; //id транспортировки
    private Long positions; // id списка позиций
    private BuyDoc buyDoc;

}
