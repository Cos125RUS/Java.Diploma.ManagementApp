package ru.steeldv.clients.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.steeldv.clients.controller.ClientsController;
import ru.steeldv.clients.model.Client;
import ru.steeldv.clients.model.OrganizationType;
import ru.steeldv.clients.repository.ClientsRepository;
import ru.steeldv.clients.service.ClientServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientsController.class)
public class ClientsControllerTest {
    @MockBean
    private ClientServiceImpl clientService;
    @Autowired
    private MockMvc mvc;

    public List<Client> clients;
    public Client client1;
    public Client client2;

    @Before
    public void init() {
        clients = new ArrayList<>();

        client1 = new Client(1L, "Org1", OrganizationType.ie);
        client2 = new Client(2L, "Org2", OrganizationType.pp);

        clients.add(client1);
        clients.add(client2);
    }

    @Test
    public void requestFindAll() throws Exception {
//        given
        given(clientService.getAllClients()).willReturn(clients);
//        when

//        then
        mvc.perform(get("/clients/findAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(Integer.parseInt(client1.getId().toString()))))
                .andExpect(jsonPath("$[0].name", is(client1.getName())))
                .andExpect(jsonPath("$[0].type", is(client1.getType().toString())))
                .andExpect(jsonPath("$[1].id", is(Integer.parseInt(client2.getId().toString()))))
                .andExpect(jsonPath("$[1].name", is(client2.getName())))
                .andExpect(jsonPath("$[1].type", is(client2.getType().toString())));
    }
}
