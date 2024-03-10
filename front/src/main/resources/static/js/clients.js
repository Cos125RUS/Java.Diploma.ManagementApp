// #region models
class clientTable {
    clientType = {
        ie: "ИП",
        llc: "ООО",
        jsc: "ОАО",
        pp: "Частное лицо"
    };

    constructor() {
        this.table = document.querySelector('div.content>table.clients-table');
        this.rows = this.table.querySelectorAll('tr.clients-table__row');
        this.types = this.table.querySelectorAll('tr.clients-table__row>td.clients-type');
        this.replaceTypes();
    }

    replaceTypes() {
        this.types.forEach(el => el.innerHTML = this.clientType[el.innerHTML]);
    }
};

// #endregion models

let table = null;


// #region init
document.addEventListener('DOMContentLoaded', event => {
    table = new clientTable();
});
// #endregion init