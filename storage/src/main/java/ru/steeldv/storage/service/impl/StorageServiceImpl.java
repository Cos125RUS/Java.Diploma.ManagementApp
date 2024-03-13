package ru.steeldv.storage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.storage.model.entity.Storage;
import ru.steeldv.storage.repository.StorageRepository;
import ru.steeldv.storage.service.StorageService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {
    private final StorageRepository storageRepository;

    @Override
    public List<Storage> findAll() {
        return storageRepository.findAll();
    }

    @Override
    public Storage addStorage(Storage storage) {
        return storageRepository.save(storage);
    }

    @Override
    public Optional<Storage> findById(Long id) {
        return storageRepository.findById(id);
    }

    @Override
    public Storage update(Storage storage) {
        return storageRepository.save(storage);
    }

    @Override
    public boolean deleteById(Long id) {
        storageRepository.deleteById(id);
        return true;
    }
}
