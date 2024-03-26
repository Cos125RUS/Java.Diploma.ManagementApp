package ru.steeldv.documents.controller.rest.doc.buy;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.documents.model.entity.doc.buy.BuyDoc;
import ru.steeldv.documents.service.doc.buy.BuyDocService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/documents/buyDoc")
public class BuyDocController {
    private final BuyDocService buyDocService;

    @GetMapping("/findAll")
    public ResponseEntity<List<BuyDoc>> findAllBuyDoc() {
        return ResponseEntity.ok(buyDocService.findAll());
    }

    @PostMapping("/addBuyDoc")
    public ResponseEntity<BuyDoc> addBuyDoc(@RequestBody BuyDoc buyDoc) {
        return ResponseEntity.ok(buyDocService.addBuyDoc(buyDoc));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BuyDoc> updateBuyDoc(@RequestBody BuyDoc buyDoc, @PathVariable Long id) {
        return ResponseEntity.ok(buyDocService.updateBuyDoc(buyDoc, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBuyDocById(@PathVariable Long id) {
        buyDocService.deleteBuyDocById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<BuyDoc> findBuyDocById(@PathVariable Long id) {
        return ResponseEntity.ok(buyDocService.findBuyDocById(id));
    }
}
