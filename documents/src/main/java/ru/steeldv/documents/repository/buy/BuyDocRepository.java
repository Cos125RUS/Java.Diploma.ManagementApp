package ru.steeldv.documents.repository.buy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.documents.entity.buy.BuyDoc;

@Repository
public interface BuyDocRepository extends JpaRepository<BuyDoc, Long> {

}
