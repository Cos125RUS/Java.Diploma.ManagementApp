package ru.steeldv.documents.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.documents.model.entity.doc.buy.BuyDoc;
import ru.steeldv.documents.model.entity.doc.storage.ComingDoc;
import ru.steeldv.documents.repository.BuyDocRepository;
import ru.steeldv.documents.repository.ComingDocRepository;
import ru.steeldv.documents.service.ComingDocService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComingDocServiceImpl implements ComingDocService {
    private final ComingDocRepository comingDocRepository;
    private final BuyDocRepository buyDocRepository;

    @Override
    public List<ComingDoc> findAll() {
        return comingDocRepository.findAll();
    }

    @Override
    public ComingDoc addComingDoc(ComingDoc comingDoc) {
        comingDoc.setDate(LocalDate.now());
        comingDoc.setTime(LocalTime.now());
        comingDoc.setLastChange(LocalDateTime.now());
        BuyDoc buyDoc = buyDocRepository.findById(comingDoc.getBuyDoc().getId()).get();
        comingDoc.setBuyDoc(buyDoc);
        return comingDocRepository.save(comingDoc);
    }

    @Override
    public ComingDoc updateComingDoc(ComingDoc comingDoc, Long id) {
        ComingDoc old = comingDocRepository.findById(id).get();
        comingDoc.setId(old.getId());
        comingDoc.setDate(old.getDate());//TODO: убрать на продакшене (данные приходят с клиента)
        comingDoc.setTime(old.getTime());//TODO: убрать на продакшене (данные приходят с клиента)
        comingDoc.setLastChange(LocalDateTime.now());
        return comingDocRepository.save(comingDoc);
    }

    @Override
    public void deleteComingDocById(Long id) {
        comingDocRepository.deleteById(id);
    }

    @Override
    public ComingDoc findComingDocById(Long id) {
        return comingDocRepository.findById(id).get();
    }
}
