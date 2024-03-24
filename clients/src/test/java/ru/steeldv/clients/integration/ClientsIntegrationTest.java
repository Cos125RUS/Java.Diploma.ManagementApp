package ru.steeldv.clients.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.steeldv.clients.controller.ClientsController;
import ru.steeldv.clients.model.Client;
import ru.steeldv.clients.model.OrganizationType;
import ru.steeldv.clients.service.ClientServiceImpl;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ClientsIntegrationTest {
    @MockBean
    private ClientServiceImpl clientService;

    @Autowired
    private ClientsController clientsController;

    @Test
    public void addClientTest() {
//        given
        Client client = new Client("Organization name", OrganizationType.ie, 123456798L,
                123456001L,"Street #1 Office #1", "+79876543215",
                "org@mail.org", 1L);
        given(clientService.addClient(client)).willReturn(client);
//        when
        Client savedClient = clientsController.addClient(client).getBody();
//        then
        assertEquals(client.getId(), Objects.requireNonNull(savedClient).getId());
        assertEquals(client.getName(), Objects.requireNonNull(savedClient).getName());
        assertEquals(client.getItn(), Objects.requireNonNull(savedClient).getItn());
        assertEquals(client.getCor(), Objects.requireNonNull(savedClient).getCor());
        assertEquals(client.getAddress(), Objects.requireNonNull(savedClient).getAddress());
        assertEquals(client.getPhone(), Objects.requireNonNull(savedClient).getPhone());
        assertEquals(client.getEmail(), Objects.requireNonNull(savedClient).getEmail());
        assertEquals(client.getManager(), Objects.requireNonNull(savedClient).getManager());
    }
}
