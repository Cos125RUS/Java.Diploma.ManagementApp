package ru.steeldv.documents.service.doc.buy;

import ru.steeldv.documents.model.entity.doc.buy.BuyDoc;

import java.util.List;

public interface BuyDocService {

    List<BuyDoc> findAll();
    BuyDoc addBuyDoc(BuyDoc buyDoc);
    BuyDoc updateBuyDoc(BuyDoc buyDoc, Long id);
    void deleteBuyDocById(Long id);
    BuyDoc findBuyDocById(Long id);
}
