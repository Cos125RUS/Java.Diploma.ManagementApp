package ru.steeldv.processor.service;

import ru.steeldv.processor.model.documents.buy.BuyDoc;

public interface DocumentSaveService {
    BuyDoc saveBuyDoc(BuyDoc buyDoc);
}
