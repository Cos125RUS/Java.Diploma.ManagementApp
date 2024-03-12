package ru.steeldv.front.service.storage;

import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.model.storage.Position;

import java.util.List;

public interface PositionService {
    Position findPositionByItemId(Long itemId);

    Position addPosition(Position position);

    Position updatePosition(Position position, Long id);

    boolean deletePosition(Long id);

    Position findPosition(Long id);
}
