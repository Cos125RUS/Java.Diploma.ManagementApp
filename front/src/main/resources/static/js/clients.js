// #region models
class ClientTable extends DataTable{
    clientType = {
        ie: "ИП",
        llc: "ООО",
        jsc: "ОАО",
        pp: "Частное лицо"
    };

    constructor() {
        super('clients');
        this.types = this.table.querySelectorAll('tr.clients-table__row>td.clients-type');
        this.replaceTypes();
    }

    replaceTypes() {
        this.types.forEach(el => el.innerHTML = this.clientType[el.innerHTML]);
    }
};
// #endregion models

// #region fields
const postUrl = '/api/clients/addClient';
const deleteUrl = '/api/clients/delete/';
let addFieldDiv = null;
let table = null;
let addForm = null;
// #endregion fields

// #region functions
const addOption = function (name, selectEl) {
    const optionEl = document.createElement('option');
    optionEl.innerHTML = name;
    selectEl.appendChild(optionEl);
};

const getType = function (element) {
    const types = ["ИП", "ООО", "ОАО", "Частное лицо"];
    return types.indexOf(element.lastChild.value);
};

const submitData = function () {
    const args = [];
    let flag = true;

    args.push(getType(addForm.firstChild));

    Array.from(addForm.children).slice(1, addForm.children.length - 1).forEach(el => {
        const value = getValue(el);
        args.push(value);
        if (!value) {
            flag = false;
        }
    });

    args[2] = Number(args[2]);
    args[3] = Number(args[3]);

    if (flag) {
        const client = new Client(...args);
        postRequest(postUrl, client);
    }
};
// #endregion functions

// #region init
const addFormInit = function (clientType) {
    addForm = document.querySelector('form.add-form');

    const clientTypeLabel = document.createElement('label');
    clientTypeLabel.textContent = 'Тип организации:';
    const clientTypeSelect = document.createElement('select');
    Object.values(clientType).forEach(type => addOption(type, clientTypeSelect));
    clientTypeLabel.appendChild(clientTypeSelect);

    addForm.appendChild(clientTypeLabel);
    addForm.appendChild(createInput('Название организации:', 'input-name', 'text'));
    addForm.appendChild(createInput('ИНН', 'input-itn', 'number'));
    addForm.appendChild(createInput('КПП', 'input-cor', 'number'));
    addForm.appendChild(createInput('Адрес:', 'input-address', 'text'));
    addForm.appendChild(createInput('Телефон:', 'input-phone', 'text'));
    addForm.appendChild(createInput('Email:', 'input-email', 'email'));

    const submitButton = document.createElement('button');
    submitButton.innerHTML = 'Создать';
    submitButton.addEventListener('click', function (e) {
        e.preventDefault();
        submitData();
    });
    addForm.appendChild(submitButton);
};

window.addEventListener('load', event => {
    table = new ClientTable();
    table.addDelButtons(deleteUrl);
    addFieldDiv = document.querySelector('div.user-interface__add-field');
    addButtonInit('client');
    addFormInit(table.clientType);
});
// #endregion init