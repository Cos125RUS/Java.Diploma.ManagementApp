package ru.steeldv.nomenclature.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.steeldv.nomenclature.entity.Position;
import ru.steeldv.nomenclature.service.PositionService;

import java.util.List;

@RestController
@RequestMapping("/nomenclature/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Position>> findPositionList(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.findPositionByListId(id));
    }
}
