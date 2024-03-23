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

    @Column(nullable = false)
    private String name;
    /**
     * Тип клиента
     */
    @Enumerated
    @Column(nullable = false)
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

    public Client(Long id, String name, OrganizationType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }


    public Client(String name, OrganizationType type, Long itn, Long cor, String address,
                  String phone, String email, Long manager) {
        this.name = name;
        this.type = type;
        this.itn = itn;
        this.cor = cor;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.manager = manager;
    }
}
