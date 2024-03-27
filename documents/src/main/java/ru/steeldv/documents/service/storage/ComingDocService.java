package ru.steeldv.documents.service.storage;

import ru.steeldv.documents.entity.storage.ComingDoc;

import java.util.List;

public interface ComingDocService {
    List<ComingDoc> findAll();
    ComingDoc addComingDoc(ComingDoc comingDoc);
    ComingDoc updateComingDoc(ComingDoc comingDoc, Long id);
    void deleteComingDocById(Long id);
    ComingDoc findComingDocById(Long id);
}
