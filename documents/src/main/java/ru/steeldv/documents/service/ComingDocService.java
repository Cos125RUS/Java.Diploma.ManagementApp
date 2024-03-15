package ru.steeldv.documents.service;

import ru.steeldv.documents.model.entity.doc.buy.BuyDoc;
import ru.steeldv.documents.model.entity.doc.storage.ComingDoc;

import java.util.List;

public interface ComingDocService {
    List<ComingDoc> findAll();
    ComingDoc addComingDoc(ComingDoc comingDoc);
    ComingDoc updateComingDoc(ComingDoc comingDoc, Long id);
    void deleteComingDocById(Long id);
    ComingDoc findComingDocById(Long id);
}
