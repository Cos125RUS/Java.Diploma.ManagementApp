package ru.steeldv.processor.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.processor.model.clients.Client;

import java.util.List;

@FeignClient(name = "clients")
public interface ClientsClientApi {
    @GetMapping("/findAll")
    public List<Client> findAll();
    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client);
    @PutMapping("/update/{id}")
    public Client update(@RequestBody Client client, @PathVariable Long id);
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id);
    @GetMapping("/findClient/{id}")
    public Client findClient(@PathVariable Long id);
}
