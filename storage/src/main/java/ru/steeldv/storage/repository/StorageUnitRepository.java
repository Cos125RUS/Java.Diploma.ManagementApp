package ru.steeldv.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.storage.model.dto.StorageUnit;
import ru.steeldv.storage.model.dto.Unit;

import java.util.List;
import java.util.Optional;

@Repository
public interface StorageUnitRepository extends JpaRepository<StorageUnit, Long> {
    Optional<StorageUnit> findById(Long id);

    Optional<List<StorageUnit>> findByAvailabilityId(Long id);
}
