package ru.steeldv.documents.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.documents.model.entity.doc.DocRegister;
import ru.steeldv.documents.model.enums.DocType;
import ru.steeldv.documents.service.DocRegisterService;

/**
 * Контролёр журнала документов
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/documents/docRegister")
public class DocRegisterController {
    private final DocRegisterService docRegisterService;

    @GetMapping("/findByDocType")
    public ResponseEntity<DocRegister> findByDocType(DocType docType) {
        return ResponseEntity.ok(docRegisterService.findByDocType(docType));
    }

    @PostMapping("/addDocRegister")
    public ResponseEntity<DocRegister> addDocRegister(DocRegister docRegister) {
        return ResponseEntity.ok(docRegisterService.addDocRegister(docRegister));
    }

    @PutMapping("/updateDocRegister")
    public ResponseEntity<DocRegister> updateDocRegister(DocRegister docRegister, Long id) {
        return ResponseEntity.ok(docRegisterService.updateDocRegister(docRegister, id));
    }

    @DeleteMapping("/deleteDocRegister")
    public ResponseEntity<Void> deleteDocRegisterById(Long id) {
        docRegisterService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
