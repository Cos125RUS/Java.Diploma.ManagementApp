package ru.steeldv.documents.repository.doc.buy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.documents.model.entity.doc.buy.BuyDoc;

@Repository
public interface BuyDocRepository extends JpaRepository<BuyDoc, Long> {

}
