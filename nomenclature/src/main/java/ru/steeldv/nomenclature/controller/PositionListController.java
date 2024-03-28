package ru.steeldv.nomenclature.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.nomenclature.entity.PositionList;
import ru.steeldv.nomenclature.service.PositionListService;

@RestController
@RequestMapping("/nomenclature/position")
@RequiredArgsConstructor
public class PositionListController {
    private final PositionListService positionListService;

    @GetMapping("/findPositionList/{id}")
    public ResponseEntity<PositionList> findPositionList(@PathVariable Long id) {
        return ResponseEntity.ok(positionListService.findById(id));
    }

    @PostMapping("/addPositionList")
    public ResponseEntity<PositionList> addPositionList(@RequestBody PositionList positionList) {
        return ResponseEntity.ok(positionListService.add(positionList));
    }

    @PutMapping("/update")
    public ResponseEntity<PositionList> updatePositionList(@RequestBody PositionList positionList) {
        return ResponseEntity.ok(positionListService.update(positionList));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePositionList(@PathVariable Long id) {
        positionListService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
