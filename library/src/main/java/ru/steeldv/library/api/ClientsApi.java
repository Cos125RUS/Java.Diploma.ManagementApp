package ru.steeldv.library.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.library.model.dto.organization.Client;

import java.util.List;

@FeignClient(name = "clients")
public interface ClientsApi {
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
