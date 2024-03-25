package ru.steeldv.documents.model.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.enums.UnitType;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "position_id")
    @JsonIgnoreProperties("units")
    private Position position;
    @Enumerated
    @Column(nullable = false, name = "unit_type")
    private UnitType unitType; // единицы измерения
    @Column(nullable = false)
    private Double quantity; // количество
}
