package ru.steeldv.documents.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.documents.model.entity.doc.buy.BuyDoc;
import ru.steeldv.documents.repository.BuyDocRepository;

import java.util.List;

public interface BuyDocService {

    List<BuyDoc> findAll();
    BuyDoc addBuyDoc(BuyDoc buyDoc);
    BuyDoc updateBuyDoc(BuyDoc buyDoc, Long id);
    void deleteBuyDocById(Long id);
    BuyDoc findBuyDocById(Long id);
}
