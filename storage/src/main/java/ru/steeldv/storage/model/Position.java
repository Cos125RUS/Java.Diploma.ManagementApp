package ru.steeldv.storage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.storage.model.enums.DocType;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    @Column(nullable = false, name = "doc_type")
    private DocType docType; // тип документа (расположение позиции)
    @Column(nullable = false, name = "document_book_id")
    private Long documentBookId; // журнал учёта
    @Column(nullable = false, name = "storage_id")
    private Long storageId; // журнал учёта
    @Column(nullable = false, name = "item_id")
    private Long itemId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("position")
    private List<Unit> units;
}
