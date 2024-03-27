package ru.steeldv.documents.controller.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.documents.entity.storage.ComingDoc;
import ru.steeldv.documents.service.storage.ComingDocService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/documents/comingDoc")
public class ComingDocController {
    private final ComingDocService comingDocService;

    @GetMapping("/findAll")
    public ResponseEntity<List<ComingDoc>> findAllComingDoc() {
        return ResponseEntity.ok(comingDocService.findAll());
    }

    @PostMapping("/addComingDoc")
    public ResponseEntity<ComingDoc> addComingDoc(@RequestBody ComingDoc ComingDoc) {
        return ResponseEntity.ok(comingDocService.addComingDoc(ComingDoc));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ComingDoc> updateComingDoc(@RequestBody ComingDoc ComingDoc, @PathVariable Long id) {
        return ResponseEntity.ok(comingDocService.updateComingDoc(ComingDoc, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComingDocById(@PathVariable Long id) {
        comingDocService.deleteComingDocById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ComingDoc> findComingDocById(@PathVariable Long id) {
        return ResponseEntity.ok(comingDocService.findComingDocById(id));
    }
}
