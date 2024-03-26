package ru.steeldv.processor.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.steeldv.processor.aspect.annotation.CallingLog;
import ru.steeldv.processor.client.DocumentsClientApi;
import ru.steeldv.processor.model.documents.buy.BuyDoc;
import ru.steeldv.processor.service.DocumentSaveService;
import ru.steeldv.processor.service.Rewritable;

@Service
@RequiredArgsConstructor
public class DocumentSaveServiceImpl implements DocumentSaveService, Rewritable {
    private final DocumentsClientApi documentsClientApi;

    @CallingLog
    @Override
    @Transactional
    public BuyDoc saveBuyDoc(BuyDoc buyDoc) {
        System.out.println(buyDoc);
        if (buyDoc.getId() == null) {

            buyDoc = documentsClientApi.addBuyDoc(buyDoc).getBody();
        }

        return buyDoc;
    }
}
