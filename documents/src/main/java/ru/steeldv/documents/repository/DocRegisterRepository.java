package ru.steeldv.documents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.documents.entity.DocRegister;
import ru.steeldv.library.model.enums.DocType;

import java.util.Optional;

@Repository
public interface DocRegisterRepository extends JpaRepository<DocRegister, Long> {
    Optional<DocRegister> findByDocType(DocType docType);
}
