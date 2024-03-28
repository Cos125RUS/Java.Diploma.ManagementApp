package ru.steeldv.nomenclature.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Соотношение товара со складом (сколько указанного товара на каком складе)
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "position_id")
    @JsonIgnoreProperties("availabilities")
    @ToString.Exclude
    private Position position;
    @ManyToOne
    @JoinColumn(name = "storage_id")
    @JsonIgnoreProperties("availabilities")
    @ToString.Exclude
    private Storage storage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "availability", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("availability")
    private List<StorageUnit> units; // соотношение единиц измерения и количества товара на конкретном складе
}
