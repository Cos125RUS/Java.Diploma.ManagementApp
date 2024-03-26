package ru.steeldv.documents.model.entity.doc.buy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.entity.doc.Applicable;
import ru.steeldv.documents.model.entity.doc.Doc;
import ru.steeldv.documents.model.entity.doc.storage.ComingDoc;
import ru.steeldv.documents.model.entity.doc.LinkedDocCreator;
import ru.steeldv.documents.model.enums.DocType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Документ о покупке
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyDoc extends Doc implements LinkedDocCreator, Applicable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private DocType type;
    @Column(nullable = false, unique = true)
    private String number;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;
    @Column(name = "last_change")
    private LocalDateTime lastChange;
    private boolean passed; //проведён / не проведён
    @Column(nullable = false)
    private Long salesman; // id продавца
    @Column(nullable = false)
    private Long manager; // id менеджера
    private Long transportation; //id транспортировки
    private Long positions; // id списка позиций
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doc", orphanRemoval = true,
//            fetch = FetchType.LAZY)
//    @JsonIgnoreProperties("doc")
//    private List<Position> positions;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "buyDoc", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("buyDoc")
    @PrimaryKeyJoinColumn(name = "coming_doc_id")
    private ComingDoc comingDoc; // документ поступления на склад
//    TODO: Денежные операции (Расчётный счёт / поступление средств / счёт-фактура и т.д.)

    @Override
    public Doc createLinkedDoc() {
        if (passed) {
            return new ComingDoc(this);
        } else {
            throw new RuntimeException("Документ не проведён");
            //TODO: заменить на кастомное исключение (непроведённый документ)
        }
    }

    @Override
    public void apply() {
        // TODO: Провести документ (запрос на процессор)
    }
}
