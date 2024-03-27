package ru.steeldv.processor.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.processor.model.documents.DocRegister;
import ru.steeldv.processor.model.documents.buy.BuyDoc;

@FeignClient(name = "documents")
public interface DocumentsApi {
//    region register
    @GetMapping("/docRegister/findByDocType/{docType}")
    public ResponseEntity<DocRegister> findByDocType(@PathVariable String docType);
    @PostMapping("/docRegister/addDocRegister/{docType}")
    public ResponseEntity<DocRegister> addDocRegister(@PathVariable String docType);
    @PutMapping("/docRegister/update")
    public ResponseEntity<DocRegister> updateDocRegister(@RequestBody DocRegister docRegister,
                                                         @PathVariable Long id);
    @DeleteMapping("/docRegister/delete")
    public ResponseEntity<Void> deleteDocRegisterById(@PathVariable Long id);
//    endregion register

//    region buy
@PostMapping("/buyDoc/addBuyDoc")
public ResponseEntity<BuyDoc> addBuyDoc(@RequestBody BuyDoc buyDoc);
    @PutMapping("/buyDoc/update/{id}")
    public ResponseEntity<BuyDoc> updateBuyDoc(@RequestBody BuyDoc buyDoc, @PathVariable Long id);
    @DeleteMapping("/buyDoc/delete/{id}")
    public ResponseEntity<Void> deleteBuyDocById(@PathVariable Long id);
    @GetMapping("/buyDoc/findById/{id}")
    public ResponseEntity<BuyDoc> findBuyDocById(@PathVariable Long id);
//    endregion buy
}
