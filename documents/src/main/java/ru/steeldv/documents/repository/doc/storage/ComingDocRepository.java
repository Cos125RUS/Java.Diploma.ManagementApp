package ru.steeldv.documents.repository.doc.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.documents.model.entity.doc.storage.ComingDoc;

@Repository
public interface ComingDocRepository extends JpaRepository<ComingDoc, Long> {
}
