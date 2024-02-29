package ru.steeldv.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.storage.model.dto.Availability;
import ru.steeldv.storage.model.dto.Position;
import ru.steeldv.storage.model.dto.Unit;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    Optional<Availability> findById(Long id);
    Optional<List<Availability>> findByPositionId(Long id);

}
