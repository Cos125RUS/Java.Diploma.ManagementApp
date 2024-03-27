package ru.steeldv.documents.model.dto.transportation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.entity.Doc;
import ru.steeldv.documents.model.enums.DeliveryType;

import java.time.LocalDate;
import java.util.List;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Delivery {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(nullable = false, name = "delivery_type")
    private DeliveryType deliveryType;
//    @ManyToMany
//    @JoinTable(joinColumns = @JoinColumn(name = "delivery_id"),
//            inverseJoinColumns = @JoinColumn(name = "doc_id"))
//    @JsonIgnoreProperties("delivery")
    private List<Doc> docs; // доставка по документу(документам)
//    @Column(nullable = false)
    private LocalDate date;
//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "delivery", fetch = FetchType.LAZY)
//    @JsonIgnoreProperties("delivery")
    private List<Driver> drivers;
}
