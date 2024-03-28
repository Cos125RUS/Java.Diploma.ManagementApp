package ru.steeldv.nomenclature.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import ru.steeldv.library.model.enums.UnitType;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StorageUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "availability_id")
    @JsonIgnoreProperties("units")
    private Availability availability;
    @Enumerated
    @Column(nullable = false, name = "unit_type")
    private UnitType unitType; // единицы измерения
    @Column(nullable = false)
    private Double quantity; // количество
}
