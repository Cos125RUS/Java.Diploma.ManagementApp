package ru.steeldv.storage.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Складская информация по позициям
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Связанный с данной позицией item из каталога
     */
    @Column(nullable = false, name = "item_id")
    private Long itemId;
    /**
     * Список с остатками в разных единицах измерения
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Unit> units; //TODO: Сделать array или map с ключом в виде UnitType, для хранения остатков в разных единицах измерения
    /**
     * Список с доступными остатками по складам
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Availability> availabilities;
}
