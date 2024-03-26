package ru.steeldv.processor.controller.doc;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.steeldv.processor.model.documents.buy.BuyDoc;
import ru.steeldv.processor.service.DocumentSaveService;

@RestController
@RequestMapping("/processor/documents/save")
@RequiredArgsConstructor
public class DocumentsSaveController {
    private final DocumentSaveService documentService;

    @GetMapping("/buyDoc")
    public ResponseEntity<BuyDoc> saveBuyDoc(@RequestBody BuyDoc buyDoc) {
        return ResponseEntity.ok(documentService.saveBuyDoc(buyDoc));
    }
}
