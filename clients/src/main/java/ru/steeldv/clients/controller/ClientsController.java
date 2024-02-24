package ru.steeldv.clients.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.clients.model.Client;
import ru.steeldv.clients.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientsController {
    private final ClientService clientService;


    @GetMapping("/findAll")
    public List<Client> findAll() {
        return clientService.getAllClients();
    }

    @PostMapping("/addClient")
    public Client addClient(Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/update")
    public Client update(Client client, Long id) {
        Client oldClient = clientService.findById(id).get();
        client.setId(oldClient.getId());
        return clientService.update(client);
    }

    @DeleteMapping("/delete")
    public boolean delete(Long id) {
        return clientService.deleteById(id);
    }

    @GetMapping("/findClient")
    public Client findClient(Long id) {
        return clientService.findById(id).get();
    }

}
