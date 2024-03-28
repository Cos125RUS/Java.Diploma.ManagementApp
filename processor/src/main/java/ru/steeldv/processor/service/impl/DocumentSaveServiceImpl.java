package ru.steeldv.processor.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.steeldv.library.api.NomenclatureApi;
import ru.steeldv.library.aspect.annotation.CallingLog;
import ru.steeldv.library.model.dto.documents.buy.BuyDoc;
import ru.steeldv.library.model.dto.nomenclature.PositionList;
import ru.steeldv.processor.api.DocumentsFeignApi;
import ru.steeldv.processor.api.NomenclatureFeignApi;
import ru.steeldv.processor.service.DocumentSaveService;
import ru.steeldv.processor.service.Rewritable;

@Service
@RequiredArgsConstructor
public class DocumentSaveServiceImpl implements DocumentSaveService, Rewritable {
    private final DocumentsFeignApi documentsApi;
    private final NomenclatureFeignApi nomenclatureApi;

    @CallingLog
    @Override
    @Transactional
    public BuyDoc saveBuyDoc(BuyDoc buyDoc) {
        System.out.println(buyDoc);
        if (buyDoc.getId() == null) {
            PositionList positionList = new PositionList(buyDoc.getPositionList());
            positionList = nomenclatureApi.addPositionList(positionList).getBody();
            buyDoc.setPositions(positionList.getId());
            buyDoc = documentsApi.addBuyDoc(buyDoc).getBody();
            return buyDoc;
        }

        return buyDoc;
    }
}
