package ru.steeldv.documents.model.entity.stransportation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.entity.docs.Doc;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "delivery_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_id"))
    @JsonIgnoreProperties("delivery")
    private List<Doc> docs; // доставка по документу(документам)
    @Column(nullable = false)
    private LocalDate date;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "delivery", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("delivery")
    private List<Driver> drivers;
}
