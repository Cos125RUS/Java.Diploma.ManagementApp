package ru.steeldv.storage.service;

import ru.steeldv.storage.model.entity.Storage;

import java.util.List;
import java.util.Optional;

public interface StorageService {
    List<Storage> findAll();

    Storage addStorage(Storage storage);

    Optional<Storage> findById(Long id);

    Storage update(Storage storage);

    boolean deleteById(Long id);
}
