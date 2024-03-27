package ru.steeldv.front.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.service.ClientsService;
import ru.steeldv.front.service.impl.ClientsServiceImpl;
import ru.steeldv.library.model.dto.organization.Client;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientsController {
    private final ClientsService clientsService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(clientsService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addClient")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientsService.addClient(client), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable Long id) {
        return new ResponseEntity<>(clientsService.update(client, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        clientsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findClient/{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id) {
        return new ResponseEntity<>(clientsService.findClient(id), HttpStatus.OK);
    }
}
