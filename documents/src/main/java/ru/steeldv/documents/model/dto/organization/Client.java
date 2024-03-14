package ru.steeldv.documents.model.dto.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.enums.OrganizationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long id;
    private String name;
    /**
     * Тип клиента
     */
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
