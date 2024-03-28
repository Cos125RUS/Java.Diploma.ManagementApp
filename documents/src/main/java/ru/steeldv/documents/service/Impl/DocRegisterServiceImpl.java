package ru.steeldv.documents.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.documents.entity.DocRegister;
import ru.steeldv.documents.repository.DocRegisterRepository;
import ru.steeldv.documents.service.DocRegisterService;
import ru.steeldv.library.aspect.annotation.CallingLog;
import ru.steeldv.library.model.enums.DocType;

import java.util.NoSuchElementException;

/**
 * Сервис журнала учёта документов
 */
@Service
@RequiredArgsConstructor
public class DocRegisterServiceImpl implements DocRegisterService {
    private final DocRegisterRepository docRegisterRepository;

    @CallingLog
    @Override
    public DocRegister addDocRegister(String docType) {
        return docRegisterRepository.save(new DocRegister(DocType.valueOf(docType)));
    }

    @Override
    public DocRegister updateDocRegister(DocRegister docRegister, Long id) {
        docRegisterRepository.findById(id).ifPresentOrElse(it -> docRegister.setId(it.getId()), () -> {
            throw new NoSuchElementException();
        });
        return docRegisterRepository.save(docRegister);
    }

    @Override
    public void deleteById(Long id) {
        docRegisterRepository.deleteById(id);
    }

    @CallingLog
    @Override
    public DocRegister findByDocType(DocType docType) {
        return docRegisterRepository.findByDocType(docType).get();
    }

    @CallingLog
    @Override
    public synchronized String getNumber(DocType docType) {
        DocRegister docRegister = docRegisterRepository.findByDocType(docType).get();
        String number = docRegister.getNumber();
        docRegisterRepository.save(docRegister);
        return number;
    }

    @Override
    public void rollBackNumber(DocType docType) {
        DocRegister docRegister = docRegisterRepository.findByDocType(docType).get();
        docRegister.decrement();
        docRegisterRepository.save(docRegister);
    }
}
