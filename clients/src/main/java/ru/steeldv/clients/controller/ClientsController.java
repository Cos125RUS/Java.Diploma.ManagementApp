package ru.steeldv.clients.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.clients.entity.Client;
import ru.steeldv.clients.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientsController {
    private final ClientService clientService;


    @GetMapping("/findAll")
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @PostMapping("/addClient")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable Long id) {
        return new ResponseEntity<>(clientService.update(client, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findClient/{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.findById(id).get(), HttpStatus.OK);
    }

}
