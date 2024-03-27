package ru.steeldv.clients.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.steeldv.clients.entity.Client;
import ru.steeldv.clients.repository.ClientsRepository;
import ru.steeldv.library.model.enums.OrganizationType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientsRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ClientsRepository clientsRepository;
    private final Client client = new Client("Organization name", OrganizationType.IE, 123456798L,
            123456001L,"Street #1 Office #1", "+79876543215",
            "org@mail.org", 1L);


    @Test
    public void findByIdTest() {
        // given
        entityManager.persistAndFlush(client);
        // when
        Client foundClient = clientsRepository.findById(client.getId()).get();
        // then
        assertEquals(foundClient.getId(), client.getId());
        assertEquals(foundClient.getName(), client.getName());
        assertEquals(foundClient.getType(), client.getType());
        assertEquals(foundClient.getItn(), client.getItn());
        assertEquals(foundClient.getCor(), client.getCor());
        assertEquals(foundClient.getAddress(), client.getAddress());
        assertEquals(foundClient.getPhone(), client.getPhone());
        assertEquals(foundClient.getEmail(), client.getEmail());
        assertEquals(foundClient.getManager(), client.getManager());
    }

    @Test
    public void deleteByIdTest() {
        // given
        entityManager.persistAndFlush(client);
        // when
        clientsRepository.deleteById(client.getId());
        // then
        assertFalse(clientsRepository.existsById(client.getId()));
    }
}
