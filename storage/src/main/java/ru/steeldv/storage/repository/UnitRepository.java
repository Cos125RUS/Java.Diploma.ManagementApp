package ru.steeldv.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.storage.entity.Unit;

import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    Optional<Unit> findById(Long id);

    Optional<Unit> findByPositionId(Long id);
}
