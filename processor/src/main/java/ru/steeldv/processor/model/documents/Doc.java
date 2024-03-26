package ru.steeldv.processor.model.documents;


import lombok.Getter;
import ru.steeldv.processor.model.enums.DocType;

@Getter
public abstract class Doc {

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "docs", fetch = FetchType.LAZY)
//    @JsonIgnoreProperties("docs")
//    private List<Delivery> delivery; //доставка(доставки)

//    protected DocType docType;
}
