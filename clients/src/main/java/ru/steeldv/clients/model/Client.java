package ru.steeldv.clients.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    /**
     * Тип клиента
     */
    @Enumerated
    private OrganizationType type;
    /**
     * ИНН
     */
    private Long itn;
    /**
     * КПП
     */
    private Long cor;
    private String address;
    private String phone;
    private String email;
    /**
     * ID менеджера
     */
    private Long manager;

    public Client(String name, OrganizationType type) {
        this.name = name;
        this.type = type;
    }
}
