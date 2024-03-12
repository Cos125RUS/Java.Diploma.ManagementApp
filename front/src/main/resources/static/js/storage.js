// #region models
class StorageTable extends DataTable {
    constructor() {
        super('storage');
    }
};
// #endregion models

// #region fields
const postUrl = '/api/storage/storage/addStorage';
const deleteUrl = '/api/storage/storage/delete/';
let addFieldDiv = null;
let table = null;
let addForm = null;
// #endregion fields

// #region functions
const submitData = function () {
    const args = [];
    let flag = true;
    const elements = Array.from(addForm.children);
    elements.pop();

    elements.forEach(element => {
        const value = getValue(element);
        if (!value) {
            flag = false;
        }
        args.push(value);
    });

    if (flag) {
        const storage = new Storage(...args);
        postRequest(postUrl, storage);
    }
};
// #endregion functions

// #region init
const addFormInit = function() {
    addForm = document.querySelector('form.add-form');

    addForm.appendChild(createInput('Название:', 'input-name', 'text'));
    addForm.appendChild(createInput('Адрес:', 'input-address', 'text'));
    addForm.appendChild(createInput('Телефон:', 'input-phone', 'text'));
    addForm.appendChild(createInput('Время работы:', 'input-working-time', 'text'));

    const submitButton = document.createElement('button');
    submitButton.innerHTML = 'Создать';
    submitButton.addEventListener('click', function (e) {
        e.preventDefault();
        submitData();
    });
    addForm.appendChild(submitButton);
};

window.addEventListener('load', event => {
    table = new StorageTable();
    table.addDelButtons(deleteUrl);
    addFieldDiv = document.querySelector('div.user-interface__add-field');
    addButtonInit('storage');
    addFormInit();
});
// #endregion init