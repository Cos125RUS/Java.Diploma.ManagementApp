package ru.steeldv.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.storage.model.Position;
import ru.steeldv.storage.model.Unit;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    Optional<Unit> findById(Long id);

    Optional<List<Position>> findByPositionId(Long id);
}
