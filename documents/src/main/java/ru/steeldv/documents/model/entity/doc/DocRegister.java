package ru.steeldv.documents.model.entity.doc;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.enums.DocType;

import java.time.LocalDate;

/**
 * Журнал учёта
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocRegister implements Registered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, updatable = false, name = "doc_type")
    private DocType docType;
    private long totalCount;
    private long yearCount;
    @Column(nullable = false)
    private String prefix; // Префикс перед номером

    public DocRegister(DocType docType) {
        this.docType = docType;
        totalCount = 0;
        yearCount = 0;
    }

    @Override
    public void newYear() {
        yearCount = 0;
    }

    @Override
    public void increment() {
        totalCount++;
        yearCount++;
    }

    @Override
    public void decrement() {
        totalCount--;
        yearCount--;
    }

    @Override
    public String getNumber() {
        increment();
        return prefix + "_" + LocalDate.now().getYear() + "_" + yearCount;
    }
}
