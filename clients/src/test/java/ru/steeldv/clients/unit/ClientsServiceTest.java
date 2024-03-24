package ru.steeldv.clients.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.steeldv.clients.model.Client;
import ru.steeldv.clients.model.OrganizationType;
import ru.steeldv.clients.repository.ClientsRepository;
import ru.steeldv.clients.service.ClientServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientsServiceTest {
    @Mock
    public ClientsRepository clientsRepository;
    @InjectMocks
    public ClientServiceImpl clientService;

    public List<Client> clients;
    public Client client1, client2, client3;


    @BeforeEach
    public void init() {
        clients = new ArrayList<>();

        client1 = new Client(1L, "Org1", OrganizationType.ie);
        client2 = new Client(2L, "Org2", OrganizationType.pp);
        client3 = new Client(3L, "Org3", OrganizationType.llc);

        clients.add(client1);
        clients.add(client2);
    }

    @Test
    public void findAllClientsSizeTest() {
//        given
        given(clientsRepository.findAll()).willReturn(clients);
//        when
        List<Client> allClients = clientService.getAllClients();
//        then
        assertEquals(Objects.requireNonNull(allClients).size(), 2);
        verify(clientsRepository).findAll();
    }

    @Test
    public void findAllClientsEqualsTest() {
//        given
        given(clientsRepository.findAll()).willReturn(clients);
//        when
        List<Client> allClients = clientService.getAllClients();
        Client returnedClient1 = allClients.get(0);
        Client returnedClient2 = allClients.get(1);
//        then
        assertEquals(returnedClient1, client1);
        assertEquals(returnedClient2, client2);
    }

    @Test
    public void addClientAppendTest() {
//        given
        given(clientsRepository.save(client3)).willReturn(client3);
//        when
        Client returnedClient = clientService.addClient(client3);
//        then
        assertEquals(returnedClient, client3);
    }

    @Test
    public void addClientSizeTest() {
//        given
        given(clientsRepository.save(client3)).willReturn(client3);
        clients.add(client3);
        given(clientsRepository.findAll()).willReturn(clients);
//        when
        clientService.addClient(client3);
        List<Client> returnedClients = clientsRepository.findAll();
//        then
        assertEquals(returnedClients.size(), 3);
    }

    @Test
    public void updateClientTest() {
//        given
        client1.setName("New Organization Name");
        given(clientsRepository.save(client1)).willReturn(client1);
//        when
        Client returnedClient = clientService.update(client1, 1L);
//        then
        assertEquals(returnedClient.getName(), "New Organization Name");
    }

    @Test
    public void deleteClientTest() {
//        given

//        when
        clientService.deleteById(1L);
//        then
        verify(clientsRepository).deleteById(1L);
    }

    @Test
    public void findByIdTest() {
//        given
        given(clientsRepository.findById(1L)).willReturn(Optional.of(client1));
//        when
        Client returnedClient = clientService.findById(1L).get();
//        then
        assertEquals(returnedClient, client1);
    }
}
