package ru.steeldv.documents.repository.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.documents.entity.storage.ComingDoc;

@Repository
public interface ComingDocRepository extends JpaRepository<ComingDoc, Long> {
}
