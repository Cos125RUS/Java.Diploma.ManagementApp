package ru.steeldv.front.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.front.api.ClientsApi;
import ru.steeldv.front.model.clients.Client;
import ru.steeldv.front.service.ClientsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {
    private final ClientsApi clientsApi;

    @Override
    public List<Client> findAll() {
        return clientsApi.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientsApi.addClient(client);
    }

    @Override
    public Client update(Client client, Long id) {
        return clientsApi.update(client, id);
    }

    @Override
    public void delete(Long id) {
        clientsApi.delete(id);
    }

    @Override
    public Client findClient(Long id) {
        return clientsApi.findClient(id);
    }
}
