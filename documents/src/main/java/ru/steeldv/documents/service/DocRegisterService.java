package ru.steeldv.documents.service;

import ru.steeldv.documents.entity.DocRegister;
import ru.steeldv.library.model.enums.DocType;

public interface DocRegisterService {
    DocRegister addDocRegister(String docType);
    DocRegister updateDocRegister(DocRegister docRegister, Long id);
    void deleteById(Long id);
    DocRegister findByDocType(DocType docType);
    String getNumber(DocType docType);
    void rollBackNumber(DocType docType);
}
