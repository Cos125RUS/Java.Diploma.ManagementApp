package ru.steeldv.documents.model.entity.prosuct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.entity.docs.Doc;

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
    @ManyToOne
    @JoinColumn(name = "doc_id")
    @JsonIgnoreProperties("positions")
    private Doc doc;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private Unit unit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Availability> availabilities;
}
