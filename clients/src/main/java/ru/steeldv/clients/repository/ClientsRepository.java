package ru.steeldv.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.steeldv.clients.model.Client;

import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(Long id);
}
