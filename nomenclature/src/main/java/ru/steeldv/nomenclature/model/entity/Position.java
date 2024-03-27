package ru.steeldv.nomenclature.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.nomenclature.model.entity.Availability;

import java.util.List;

/**
 * Позиция в списке номенклатуры
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "item_id")
    private Long itemId;
    @Column(nullable = false, name = "list_id")
    private Long listId; // идентификатор списка позиций
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Unit> units; // количество в разных единицах измерения
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Availability> availabilities;// соотношение количества товаров и складов (откуда сколько)
}
