package ru.steeldv.documents.controller.rest.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.steeldv.documents.model.entity.product.Position;
import ru.steeldv.documents.service.product.PositionService;

import java.util.List;

@RestController
@RequestMapping("/documents/product/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Position>> findPositionList(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.findPositionByListId(id));
    }
}
