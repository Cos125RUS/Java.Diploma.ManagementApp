package ru.steeldv.documents.service.buy;

import ru.steeldv.documents.entity.buy.BuyDoc;

import java.util.List;

public interface BuyDocService {

    List<BuyDoc> findAll();
    BuyDoc addBuyDoc(BuyDoc buyDoc);
    BuyDoc updateBuyDoc(BuyDoc buyDoc, Long id);
    void deleteBuyDocById(Long id);
    BuyDoc findBuyDocById(Long id);
}
