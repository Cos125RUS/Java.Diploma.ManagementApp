package ru.steeldv.clients.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.steeldv.clients.model.Client;
import ru.steeldv.clients.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientsController {
    private final ClientService clientService;


    @GetMapping
    public List<Client> findAll() {
        return clientService.getAllClients();
    }
}
