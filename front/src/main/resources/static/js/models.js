const units = {
    kilogram: "кг",
    ton: "т",
    unit: "шт",
    coil: "бухты",
    roll: "рулоны",
    meter: "метры",
    m2: "кв.метры",
    m3: "кубометры"
};

class Client {
    constructor(type, name, itn, cor, address, phone, email) {
        this.type = type,
            this.name = name,
            this.itn = itn,
            this.cor = cor,
            this.address = address,
            this.phone = phone,
            this.email = email
    }
};

class Storage {
    constructor(name, address, phone, workingTime) {
        this.name = name,
        this.address = address,
        this.phone = phone,
        this.workingTime = workingTime
    }
};

class DataTable {
    constructor(entityName) {
        this.table = document.querySelector(`div.content>table.${entityName}-table`);
        this.rows = this.table.querySelectorAll(`tr.${entityName}-table__row`);
    }

    addDelButtons(deleteUrl) {
        Array.from(this.rows).forEach(row => {
            const delButton = row.querySelector('button.del-button');
            delButton.addEventListener('click', function (e) {
                const id = row.id;
                deleteRequest(deleteUrl+`${id}`);
            });
        });
    }
};