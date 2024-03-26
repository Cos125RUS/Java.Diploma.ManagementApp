package ru.steeldv.documents.service.doc;

import ru.steeldv.documents.model.entity.doc.DocRegister;
import ru.steeldv.documents.model.enums.DocType;

public interface DocRegisterService {
    DocRegister addDocRegister(String docType);
    DocRegister updateDocRegister(DocRegister docRegister, Long id);
    void deleteById(Long id);
    DocRegister findByDocType(DocType docType);
    String getNumber(DocType docType);
}
