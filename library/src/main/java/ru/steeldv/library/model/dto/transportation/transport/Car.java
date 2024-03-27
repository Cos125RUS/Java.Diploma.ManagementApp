package ru.steeldv.library.model.dto.transportation.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.library.model.dto.transportation.Driver;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private Long id;
    private Driver driver;
    private String brand;
    private String number; //автомобильный номер
    private Double capacity; // грузоподъёмность
    private String color;
    private int axle; //количество осей
    private boolean openTop;
}
