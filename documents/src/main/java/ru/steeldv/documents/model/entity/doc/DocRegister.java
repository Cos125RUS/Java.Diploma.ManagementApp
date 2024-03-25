package ru.steeldv.documents.model.entity.doc;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.enums.DocType;

/**
 * Журнал учёта
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, name = "doc_type")
    private DocType docType;
    private int count;

    public DocRegister(DocType docType) {
        this.docType = docType;
        count = 0;
    }
}
