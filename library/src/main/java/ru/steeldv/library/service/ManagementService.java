package ru.steeldv.library.service;

import java.util.List;

public interface ManagementService<T> {
    List<T> findAll();
    T add(T entity);
    T findById(Long id);
    void deleteById(Long id);
}
