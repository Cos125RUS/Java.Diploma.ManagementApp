package ru.steeldv.processor.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.steeldv.library.aspect.annotation.CallingLog;
import ru.steeldv.library.model.dto.documents.buy.BuyDoc;
import ru.steeldv.processor.api.DocumentsFeignApi;
import ru.steeldv.processor.service.DocumentSaveService;
import ru.steeldv.processor.service.Rewritable;

@Service
@RequiredArgsConstructor
public class DocumentSaveServiceImpl implements DocumentSaveService, Rewritable {
    private final DocumentsFeignApi documentsApi;

    @CallingLog
    @Override
    @Transactional
    public BuyDoc saveBuyDoc(BuyDoc buyDoc) {
        System.out.println(buyDoc);
        if (buyDoc.getId() == null) {

//            buyDoc = documentsApi.addBuyDoc(buyDoc).getBody();
        }

        return buyDoc;
    }
}
