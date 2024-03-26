package ru.steeldv.documents.model.entity.product;

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
    @Column(nullable = false, name = "item_id")
    private Long itemId;
    @Column(nullable = false, name = "list_id")
    private Long listId; // идентификатор списка позиций
//    @ManyToOne
//    @JoinColumn(name = "doc_id")
//    @JsonIgnoreProperties("positions")
//    private Doc doc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Unit> units;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Availability> availabilities;
}
