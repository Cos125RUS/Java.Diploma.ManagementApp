package ru.steeldv.front.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.steeldv.front.client.ClientsClientApi;
import ru.steeldv.front.model.clients.Client;
import ru.steeldv.front.service.ClientsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {
    private final ClientsClientApi clientsClientApi;

    @Override
    public List<Client> findAll() {
        return clientsClientApi.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientsClientApi.addClient(client);
    }

    @Override
    public Client update(Client client, Long id) {
        return clientsClientApi.update(client, id);
    }

    @Override
    public boolean delete(Long id) {
        return clientsClientApi.delete(id);
    }

    @Override
    public Client findClient(Long id) {
        return clientsClientApi.findClient(id);
    }
}
