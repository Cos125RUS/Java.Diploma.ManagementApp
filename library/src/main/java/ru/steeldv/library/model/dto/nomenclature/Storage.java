package ru.steeldv.library.model.dto.nomenclature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Storage {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String workingTime;
    private List<Availability> availabilities;
}
