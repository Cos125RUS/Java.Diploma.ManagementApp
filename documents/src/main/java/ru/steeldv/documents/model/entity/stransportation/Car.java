package ru.steeldv.documents.model.entity.stransportation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnoreProperties("cars")
    private Driver driver;
    private String brand;
    private String number; //автомобильный номер
    private Double capacity; // грузоподъёмность
    private String color;
    private int axle; //количество осей
    @Column(name = "open_top")
    private boolean openTop;
}
