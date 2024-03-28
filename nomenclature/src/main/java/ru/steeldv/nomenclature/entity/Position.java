package ru.steeldv.nomenclature.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Позиция в списке номенклатуры
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "item_id")
    private Long itemId;
    @ManyToOne
    @JoinColumn(name = "position_list_id")
    @JsonIgnoreProperties("positions")
    private PositionList positionList; // идентификатор списка позиций
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Unit> units; // количество в разных единицах измерения
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Availability> availabilities;// соотношение количества товаров и складов (откуда сколько)
}
