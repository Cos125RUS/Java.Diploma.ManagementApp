package ru.steeldv.documents.model.entity.prosuct;

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
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String address;
    private String phone;
    @Column(name = "working_time")
    private String workingTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storage", orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties("storage")
    private List<Availability> availabilities;
}
