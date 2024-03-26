package ru.steeldv.documents.repository.doc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.documents.model.entity.doc.DocRegister;
import ru.steeldv.documents.model.enums.DocType;

import java.util.Optional;

@Repository
public interface DocRegisterRepository extends JpaRepository<DocRegister, Long> {
    Optional<DocRegister> findByDocType(DocType docType);
}
