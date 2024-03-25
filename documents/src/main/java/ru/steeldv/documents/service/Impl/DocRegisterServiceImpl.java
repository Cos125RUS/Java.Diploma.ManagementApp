package ru.steeldv.documents.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.documents.model.entity.doc.DocRegister;
import ru.steeldv.documents.model.enums.DocType;
import ru.steeldv.documents.repository.DocRegisterRepository;
import ru.steeldv.documents.service.DocRegisterService;

import java.util.NoSuchElementException;

/**
 * Сервис журнала учёта документов
 */
@Service
@RequiredArgsConstructor
public class DocRegisterServiceImpl implements DocRegisterService {
    private final DocRegisterRepository docRegisterRepository;

    @Override
    public DocRegister addDocRegister(DocRegister docRegister) {
        return docRegisterRepository.save(docRegister);
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

    @Override
    public DocRegister findByDocType(DocType docType) {
        return docRegisterRepository.findByDocType(docType).get();
    }
}
