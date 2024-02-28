package ru.steeldv.storage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    @JsonIgnoreProperties("positions")
    private Item item;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Unit> units;
}
