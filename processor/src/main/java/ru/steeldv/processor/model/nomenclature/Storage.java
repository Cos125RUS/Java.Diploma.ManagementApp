package ru.steeldv.processor.model.nomenclature;

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
