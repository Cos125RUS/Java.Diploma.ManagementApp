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
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/update/{id}")
    public Client update(@RequestBody Client client, @PathVariable Long id) {
        Client oldClient = clientService.findById(id).get();
        client.setId(oldClient.getId());
        return clientService.update(client);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return clientService.deleteById(id);
    }

    @GetMapping("/findClient/{id}")
    public Client findClient(@PathVariable Long id) {
        return clientService.findById(id).get();
    }

}
