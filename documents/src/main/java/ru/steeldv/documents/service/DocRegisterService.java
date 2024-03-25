package ru.steeldv.documents.service;

import ru.steeldv.documents.model.entity.doc.DocRegister;
import ru.steeldv.documents.model.enums.DocType;

public interface DocRegisterService {
    DocRegister addDocRegister(DocRegister docRegister);
    DocRegister updateDocRegister(DocRegister docRegister, Long id);
    void deleteById(Long id);
    DocRegister findByDocType(DocType docType);
}
