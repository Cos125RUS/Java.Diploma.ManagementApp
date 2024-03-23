package ru.steeldv.front.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.steeldv.front.model.clients.Client;

import java.util.List;

public interface ClientsService {
    public List<Client> findAll();

    public Client addClient(Client client);

    public Client update(Client client, Long id);

    public void delete(Long id);

    public Client findClient(Long id);

}
