package ru.steeldv.clients.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.clients.entity.Client;
import ru.steeldv.clients.repository.ClientsRepository;
//import ru.steeldv.library.aspect.annotation.CallingLog;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientsRepository clientsRepository;

//    @CallingLog
    @Override
    public List<Client> getAllClients() {
        return clientsRepository.findAll();
    }

//    @CallingLog
    @Override
    public Client addClient(Client client) {
        return clientsRepository.save(client);
    }

//    @CallingLog
    @Override
    public Optional<Client> findById(Long id) {
        return clientsRepository.findById(id);
    }

//    @CallingLog
    @Override
    public Client update(Client client, Long id) {
        findById(id).ifPresentOrElse(it -> client.setId(it.getId()), () -> {
            throw new NoSuchElementException();
        });
        return clientsRepository.save(client);
    }

//    @CallingLog
    @Override
    public void deleteById(Long id) {
        clientsRepository.deleteById(id);
    }
}
