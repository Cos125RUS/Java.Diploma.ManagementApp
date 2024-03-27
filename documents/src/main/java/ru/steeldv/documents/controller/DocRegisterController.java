package ru.steeldv.documents.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.documents.entity.DocRegister;
import ru.steeldv.documents.service.DocRegisterService;
import ru.steeldv.library.model.enums.DocType;

/**
 * Контролёр журнала документов
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/documents/docRegister")
public class DocRegisterController {
    private final DocRegisterService docRegisterService;

    @GetMapping("/findByDocType/{docType}")
    public ResponseEntity<DocRegister> findByDocType(@PathVariable String docType) {
        return ResponseEntity.ok(docRegisterService.findByDocType(DocType.valueOf(docType)));
    }

    @PostMapping("/addDocRegister/{docType}")
    public ResponseEntity<DocRegister> addDocRegister(@PathVariable String docType) {
        return ResponseEntity.ok(docRegisterService.addDocRegister(docType));
    }

    @PutMapping("/update")
    public ResponseEntity<DocRegister> updateDocRegister(@RequestBody DocRegister docRegister,
                                                         @PathVariable Long id) {
        return ResponseEntity.ok(docRegisterService.updateDocRegister(docRegister, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteDocRegisterById(@PathVariable Long id) {
        docRegisterService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
