package ru.steeldv.library.model.dto.transportation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.library.model.dto.transportation.transport.Car;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {
    private Long id;
    private Long person; //id персоны
    private List<Car> cars; //Машины водителя
    private List<Delivery> delivery;
}
