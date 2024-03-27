package ru.steeldv.documents.model.entity;


import ru.steeldv.documents.model.enums.DocType;

public abstract class Doc {

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "docs", fetch = FetchType.LAZY)
//    @JsonIgnoreProperties("docs")
//    private List<Delivery> delivery; //доставка(доставки)
    protected DocType docType;
}
