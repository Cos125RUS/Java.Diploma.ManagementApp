// #region models
class ClientTable {
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
// #endregion models

// #region fields
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

const createInput = function (text, className, type) {
    const labelEl = document.createElement('label');
    labelEl.textContent = text;
    const inputEl = document.createElement('input');
    inputEl.classList.add(className);
    inputEl.type = type;
    labelEl.appendChild(inputEl);
    return labelEl;
};

const getValue = function (element) {
    const inputEl = element.lastChild;
    const value = inputEl.value;
    if (value == '') {
        inputEl.classList.add('error');
    } else if (inputEl.classList.contains('error')) {
        inputEl.classList.remove('error');
    }
    return value;
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
        postRequest(client);
    }
};
// #endregion functions

// #region requests
const postRequest = function (data) {
    const url = '/api/clients/addClient';
    const body = JSON.stringify(data);
    doRequest(url, 'POST', body);
};

const deleteRequest = function (id) {
    const url = `/api/clients/delete/${id}`;
    doRequest(url, 'DELETE');
};

const doRequest = (url, method, body) => {
    fetch(url, {
        method: method,
        headers: {
            "Content-type": "application/json;charset=UTF-8"
        },
        body: body
    })
        .then(response => {
            if (response.ok) {
                window.location.reload();
            }
        });
}
// #endregion requests

// #region init
const addButtonInit = function () {
    const addButton = document.querySelector('button.add-client-button');
    addButton.addEventListener('click', function (e) {
        addFieldDiv.classList.toggle('hidden');
        addButton.classList.toggle('hidden');
    });
};

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

const addDelButtons = function() {
    Array.from(table.rows).forEach(row => {
        const delButton = row.querySelector('button.del-button');
        delButton.addEventListener('click', function (e) {
            const id = row.id;
            deleteRequest(id);
        });
    });
};

window.addEventListener('load', event => {
    table = new ClientTable();
    addFieldDiv = document.querySelector('div.user-interface__add-field');
    addButtonInit();
    addFormInit(table.clientType);
    addDelButtons();
});
// #endregion init