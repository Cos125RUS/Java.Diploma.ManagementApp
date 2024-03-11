package ru.steeldv.front.service.storage;

import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.model.storage.Storage;

import java.util.List;

public interface StorageService {
    List<Storage> findAllStorage();

    Storage addStorage(Storage storage);

    Storage updateStorage(Storage storage, Long id);

    boolean deleteStorage(Long id);

    Storage findStorage(Long id);
}
