package ru.steeldv.processor.service;


import ru.steeldv.library.model.dto.documents.buy.BuyDoc;

public interface DocumentSaveService {
    BuyDoc saveBuyDoc(BuyDoc buyDoc);
}
