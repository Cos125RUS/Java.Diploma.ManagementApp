package ru.steeldv.clients.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.clients.aspect.Logging;
import ru.steeldv.clients.model.Client;
import ru.steeldv.clients.repository.ClientsRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientsRepository clientsRepository;

    @Logging
    @Override
    public List<Client> getAllClients() {
        return clientsRepository.findAll();
    }

    @Logging
    @Override
    public Client addClient(Client client) {
        return clientsRepository.save(client);
    }

    @Logging
    @Override
    public Optional<Client> findById(Long id) {
        return clientsRepository.findById(id);
    }

    @Logging
    @Override
    public Client update(Client client, Long id) {
        findById(id).ifPresentOrElse(it -> client.setId(it.getId()), () -> {
            throw new NoSuchElementException();
        });
        return clientsRepository.save(client);
    }

    @Logging
    @Override
    public void deleteById(Long id) {
        clientsRepository.deleteById(id);
    }
}
