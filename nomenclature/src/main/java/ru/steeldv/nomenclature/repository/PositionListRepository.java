package ru.steeldv.nomenclature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.nomenclature.entity.Position;
import ru.steeldv.nomenclature.entity.PositionList;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionListRepository extends JpaRepository<PositionList, Long> {
}
