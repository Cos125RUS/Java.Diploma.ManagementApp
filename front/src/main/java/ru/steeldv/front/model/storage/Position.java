package ru.steeldv.front.model.storage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {
    private Long id;
    private Long itemId;
    private List<Unit> units;
    private List<Availability> availabilities;
}
