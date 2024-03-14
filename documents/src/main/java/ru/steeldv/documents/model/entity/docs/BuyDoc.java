package ru.steeldv.documents.model.entity.docs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.documents.model.entity.prosuct.Position;
import ru.steeldv.documents.model.entity.stransportation.Delivery;
import ru.steeldv.documents.model.enums.DeliveryType;
import ru.steeldv.documents.model.enums.DocType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Документ о покупке
 */
@Data
public class BuyDoc extends Doc {

}
