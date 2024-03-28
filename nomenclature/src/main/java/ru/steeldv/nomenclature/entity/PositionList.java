package ru.steeldv.nomenclature.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Список позиций товара
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "position_list")
public class PositionList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "positionList", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("positionList")
    private List<Position> positions; // позиции в списке
}
