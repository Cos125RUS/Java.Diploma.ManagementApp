package ru.steeldv.storage.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Доступные остатки по указанному складу
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
    private Position position;
    @ManyToOne
    @JoinColumn(name = "storage_id")
    @JsonIgnoreProperties("availabilities")
    private Storage storage;
    /**
     * Список с остатками на складе в разных единицах измерения
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "availability", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("availability")
    private List<StorageUnit> units;
}
