package ru.steeldv.storage.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.storage.model.enums.UnitType;

/**
 * Остатки в указанных единицах измерения на определённом складе
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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
