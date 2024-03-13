package ru.steeldv.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.storage.model.entity.Storage;

import java.util.Optional;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
    Optional<Storage> findById(Long id);
}
