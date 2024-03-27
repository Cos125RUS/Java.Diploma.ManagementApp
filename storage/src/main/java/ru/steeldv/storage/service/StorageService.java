package ru.steeldv.storage.service;

import ru.steeldv.storage.entity.Storage;

import java.util.List;
import java.util.Optional;

public interface StorageService {
    List<Storage> findAll();

    Storage addStorage(Storage storage);

    Storage findById(Long id);

    Storage update(Storage storage, Long id);

    void deleteById(Long id);
}
