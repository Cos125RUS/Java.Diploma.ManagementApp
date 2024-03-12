// #region requests
const getRequest = function (url) {
    return fetch(url, {
        method: "GET",
        headers: {
            "Content-type": "application/json;charset=UTF-8"
        }
    });
};

const postRequest = function (url, data) {
    const body = JSON.stringify(data);
    doRequest(url, 'POST', body);
};

const deleteRequest = function (url) {
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
};
// #endregion requests

const addButtonInit = function (entityType) {
    const addButton = document.querySelector(`button.add-${entityType}-button`);
    addButton.addEventListener('click', function (e) {
        addFieldDiv.classList.toggle('hidden');
        addButton.classList.toggle('hidden');
    });
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