package ru.steeldv.processor.model.storage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Availability {
    private Long id;
    private Position position;
    private Storage storage;
    private StorageUnit unit;
}
