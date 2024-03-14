package ru.steeldv.documents.model.dto.transportation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.dto.transportation.transport.Car;

import java.util.List;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(nullable = false)
    private Long person; //id персоны
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver", orphanRemoval = true,
//            fetch = FetchType.LAZY)
//    @JsonIgnoreProperties("driver")
    private List<Car> cars; //Машины водителя
//    @ManyToMany
//    @JoinTable(joinColumns = @JoinColumn(name = "driver_id"),
//            inverseJoinColumns = @JoinColumn(name = "delivery_id"))
//    @JsonIgnoreProperties("drivers")
    private List<Delivery> delivery;
}
