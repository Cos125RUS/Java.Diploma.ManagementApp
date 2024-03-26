package ru.steeldv.processor.model.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.steeldv.processor.model.enums.DocType;

/**
 * Журнал учёта
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocRegister {
    private Long id;
    private DocType docType;
    private long totalCount;
    private long yearCount;

}
