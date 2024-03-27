package ru.steeldv.clients.service;

import ru.steeldv.clients.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAllClients();
    Client addClient(Client client);
    Optional<Client> findById(Long id);
    Client update(Client client, Long id);
    void deleteById(Long id);
}
