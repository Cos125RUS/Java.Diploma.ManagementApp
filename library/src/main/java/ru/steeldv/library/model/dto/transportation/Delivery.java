package ru.steeldv.library.model.dto.transportation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.library.model.dto.documents.Doc;
import ru.steeldv.library.model.enums.DeliveryType;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Delivery {
    private Long id;
    private DeliveryType deliveryType;
    private List<Doc> docs; // доставка по документу(документам)
    private LocalDate date;
    private List<Driver> drivers;
}
