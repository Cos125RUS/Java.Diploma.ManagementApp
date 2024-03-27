package ru.steeldv.documents.entity.storage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.entity.Applicable;
import ru.steeldv.documents.entity.Doc;
import ru.steeldv.documents.entity.buy.BuyDoc;
import ru.steeldv.library.model.enums.DocType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComingDoc extends Doc implements Applicable {
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
    @OneToOne
    @JoinColumn(name = "buy_doc_id")
    @JsonIgnoreProperties("comingDoc")
    @PrimaryKeyJoinColumn(name = "buy_doc_id")
    private BuyDoc buyDoc;

    public ComingDoc(BuyDoc buyDoc) {
        type = DocType.COMING_DOC;
        date = LocalDate.now();
        time = LocalTime.now();
        lastChange = LocalDateTime.now();
        salesman = buyDoc.getSalesman();
        manager = buyDoc.getManager();
        transportation = buyDoc.getTransportation();
        positions = buyDoc.getPositions();
        this.buyDoc = buyDoc;
    }

    @Override
    public void apply() {

    }
}
