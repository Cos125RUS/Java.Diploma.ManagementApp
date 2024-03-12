package ru.steeldv.storage.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    @JsonIgnoreProperties("availabilities")
    private Position position;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    @JsonIgnoreProperties("availabilities")
    private Storage storage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "availability", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("availability")
    private List<StorageUnit> units;
}
