package ru.steeldv.documents.model.entity.docs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.entity.prosuct.Position;
import ru.steeldv.documents.model.entity.stransportation.Delivery;
import ru.steeldv.documents.model.enums.DocType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private DocType type;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;
    private boolean passed; //проведён / не проведён
    @Column(nullable = false)
    private Long client; // id контрагента
    @Column(nullable = false)
    private Long manager; // id менеджера
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "docs", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("docs")
    private List<Delivery> delivery; //вид поставки(поставок)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doc", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("doc")
    private List<Position> positions;
}
