package ru.steeldv.clients.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.clients.model.Client;
import ru.steeldv.clients.repository.ClientsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientsRepository clientsRepository;

    @Override
    public List<Client> getAllClients() {
        return clientsRepository.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientsRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientsRepository.findById(id);
    }

    @Override
    public Client update(Client client) {
        return clientsRepository.save(client);
    }

    @Override
    public boolean deleteById(Long id) {
        clientsRepository.deleteById(id);
        return true;
    }
}
