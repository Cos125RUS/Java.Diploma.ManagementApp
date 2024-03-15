package ru.steeldv.documents.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.documents.model.entity.doc.buy.BuyDoc;
import ru.steeldv.documents.repository.BuyDocRepository;
import ru.steeldv.documents.service.BuyDocService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyDocServiceImpl implements BuyDocService {
    private final BuyDocRepository buyDocRepository;

    @Override
    public List<BuyDoc> findAll() {
        return buyDocRepository.findAll();
    }

    @Override
    public BuyDoc addBuyDoc(BuyDoc buyDoc) {
        buyDoc.setDate(LocalDate.now());
        buyDoc.setTime(LocalTime.now());
        buyDoc.setLastChange(LocalDateTime.now());
        return buyDocRepository.save(buyDoc);
    }

    @Override
    public BuyDoc updateBuyDoc(BuyDoc buyDoc, Long id) {
        BuyDoc old = buyDocRepository.findById(id).get();
        buyDoc.setId(old.getId());
        buyDoc.setDate(old.getDate());//TODO: убрать на продакшене (данные приходят с клиента)
        buyDoc.setTime(old.getTime());//TODO: убрать на продакшене (данные приходят с клиента)
        buyDoc.setLastChange(LocalDateTime.now());
        return buyDocRepository.save(buyDoc);
    }

    @Override
    public void deleteBuyDocById(Long id) {
        buyDocRepository.deleteById(id);
    }

    @Override
    public BuyDoc findBuyDocById(Long id) {
        return buyDocRepository.findById(id).get();
    }
}
