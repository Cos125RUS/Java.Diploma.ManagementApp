package ru.steeldv.library.service;

import java.util.List;
import java.util.Optional;

public interface CRUDService<T> {
    List<T> findAll();
    T add(T entity);
    T findById(Long id);
    T update(T entity, Long id);
    void deleteById(Long id);
}
