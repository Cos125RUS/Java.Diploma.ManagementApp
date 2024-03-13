// #region models
const postUrl = {
    catalog: '/api/catalog/category/addCategory',
    category: '/api/catalog/subcategory/addSubcategory',
    subcategories: '/api/catalog/product/addProduct',
    products: '/api/catalog/item/addItem'
};

const delUrl = {
    category: '/api/catalog/category/delete/',
    subcategories: '/api/catalog/subcategory/delete/',
    products: '/api/catalog/product/delete/',
    items: '/api/catalog/item/delete/'
};

const getUrl = {
    catalog: '/api/catalog/category/findAll',
    positions: '/api/storage/position/findByItemId/'
}

const currentElement = {
    category: {
        name: null,
        id: null
    },
    subcategories: {
        name: null,
        id: null
    },
    products: {
        name: null,
        id: null
    },
    items: {
        name: null,
        id: null
    }
};
// #endregion

// #region userInterface
const catalogAddButton = document.querySelector('button.add-category-button');
catalogAddButton.addEventListener('click', function (e) {
    showAddInterface('catalog');
});

// #endregion

// #region catalogList
let categories = null;

document.addEventListener('DOMContentLoaded', function (e) {
    getRequest(getUrl['catalog'])
        .then(response => response.text())
        .then(responseText => {
            categories = JSON.parse(responseText);
    });
});

const createUl = (parentElement, list, className, hidden) => {
    const ulElement = document.createElement('ul');
    parentElement.appendChild(ulElement);
    ulElement.classList.add(className);
    list.forEach(element => {
        ulElement.appendChild(createLi(element, className));
    });
    if (hidden) {
        ulElement.classList.add(hidden);
        const pName = ulElement.previousElementSibling.querySelector('p');
        pName.addEventListener('click', function (e) {
            if (ulElement.classList.contains('hidden')) {
                ulElement.classList.remove('hidden');
            } else {
                ulElement.classList.add('hidden');
            }
        });
    }
};

const createLi = (element, className) => {
    const liElement = document.createElement('li');
    liElement.classList.add(className);
    const divLi = document.createElement('div');
    divLi.classList.add('li-elements-block');
    liElement.appendChild(divLi);
    const pName = document.createElement('p');
    pName.classList.add('position');
    divLi.appendChild(pName);
    const delButton = document.createElement('button');
    delButton.innerHTML = 'x';
    delButton.classList.add('li-buttons');
    divLi.appendChild(delButton);
    delButton.addEventListener('click', function (e) {
        deleteRequestProcessing(className, element.id);
    });
    if (Object.keys(element).indexOf('name') !== -1) {
        pName.textContent = element.name;
        pName.dataset.id = element.id;
        pName.dataset.catalogType = className;
        let counter = 0;
        Object.values(element).forEach(value => {
            if (Array.isArray(value)) {
                createUl(liElement, value, Object.keys(element)[counter], 'hidden');
            }
            counter++;
        });
        const addButton = document.createElement('button');
        addButton.classList.add('li-buttons');
        addButton.innerHTML = '+';
        divLi.appendChild(addButton);
        addButton.addEventListener('click', function (e) {
            showAddInterface(className, element.id);
        });
    } else if (Object.keys(element).indexOf('print') !== -1) {
        pName.textContent = element.print + ' | ' + element.weight + units[element.baseUnitType] + ' | ' + element.unitPrice + 'р/' + units[element.baseUnitType];
        getPosition(element.id, pName);
        pName.dataset.catalogType = className;
        pName.dataset.id = element.id;
        pName.addEventListener('click', function (e) {
            // TODO: дополнительная информация по остаткам на складах
        });
    }
    return liElement;
};

const getPosition = function(id, element) {
    const url = `${getUrl['positions']}${id}`;
    const request = getRequest(url);
    request
        .then(response => response.text())//TODO: добавить проверку найденного значения
        .then(responseText => {
            const position = JSON.parse(responseText);
            if (typeof position.unit !== 'undefined') {
                element.textContent += ' | ' + position.unit.quantity + units[position.unit.unitType];
                element.dataset.positionId = position.id;
                element.dataset.unitId = position.unit.id;
            }
        });
}

const showAddInterface = (className, id) => {
    catalogAddButton.classList.add('hidden');
    const addInterface = document.querySelector('div.user-interface__add-field');
    if (addInterface.classList.contains('hidden')) {
        addInterface.classList.remove('hidden');
    }
    const addForm = document.querySelector('form.add-form');
    Array.from(addForm.children).forEach(el => el.remove());
    switch (className) {
        case 'catalog':
            addForm.appendChild(createInputField('Категория:', 'category-input'));
            break;
        case 'category':
            addForm.appendChild(createInputField('Подкатегория:', 'subcategory-input'));
            break;
        case 'subcategories':
            addForm.appendChild(createInputField('Позиция:', 'product-input'));
            break;
        case 'products':
            addForm.appendChild(createInputField('Отображение:', 'print-input'));
            addForm.appendChild(createInputField('Толщина:', 'thickness-input'));
            addForm.appendChild(createInputField('Габариты:', 'size-input'));
            addForm.appendChild(createInputField('Вес:', 'weight-input'));
            addForm.appendChild(createUnitTypeSection());
            addForm.appendChild(createInputField('Цена:', 'price-input'));
            addForm.appendChild(createInputField('Стоимость резки:', 'cutting-input'));
            break;
    }
    const addButton = document.createElement('button');
    addButton.innerHTML = 'Добавить';
    addButton.type = 'submit';
    addForm.appendChild(addButton);
    addButton.addEventListener('click', function (e) {
        e.preventDefault();
        addSubmit(addForm, className, id);
    });
};

const createInputField = (title, className) => {
    const labelName = document.createElement('label');
    const inputEl = document.createElement('input');
    inputEl.classList.add(className);
    labelName.innerHTML = title;
    labelName.appendChild(inputEl);
    return labelName;
};

const createUnitTypeSection = () => {
    const unitTypeSelectEl = document.createElement('select');
    unitTypeSelectEl.classList.add('unit-type-select');
    unitTypeSelectEl.appendChild(createOption('kilogram', 'кг'));
    unitTypeSelectEl.appendChild(createOption('ton', 'т'));
    unitTypeSelectEl.appendChild(createOption('unit', 'шт'));
    return unitTypeSelectEl;
};

const createOption = (value, text) => {
    const optionEl = document.createElement('option');
    optionEl.value = value;
    optionEl.innerHTML = text;
    return optionEl;
};

const addSubmit = (formEl, className, id) => {
    let value = null;
    switch (className) {
        case 'catalog':
            value = fieldCheck(formEl, '.category-input');
            if (value) {
                postRequestProcessing({ "name": value }, className);
            }
            break;
        case 'category':
            value = fieldCheck(formEl, '.subcategory-input');
            if (value) {
                const subcategory = {
                    "name": value,
                    "category": {
                        "id": id
                    }
                };
                postRequestProcessing(subcategory, className);
            }
            break;
        case 'subcategories':
            value = fieldCheck(formEl, '.product-input');
            if (value) {
                const content = document.querySelector('div.container>main.main>div.content>ul.category');
                const positions = content.querySelectorAll('p.position');
                const subcategoryEl = Array.from(positions).filter(el => el.dataset.id == id && el.dataset.catalogType == 'subcategories')[0];
                const categoryEl = subcategoryEl.parentElement.parentElement.parentElement.previousElementSibling.firstChild;
                const catalogId = categoryEl.dataset.id;
                const product = {
                    "name": value,
                    "category": {
                        "id": catalogId
                    },
                    "subcategory": {
                        "id": id
                    }
                };
                postRequestProcessing(product, className);
            }
            break;
        case 'products':
            const print = fieldCheck(formEl, '.print-input');
            const unitType = fieldCheck(formEl, '.unit-type-select');
            const price = fieldCheck(formEl, '.price-input');
            if (print && unitType && price) {
                const item = {
                    "product": {
                        "id": id
                    },
                    "print": print,
                    "thickness": Number(fieldCheck(formEl, '.thickness-input')),
                    "size": fieldCheck(formEl, '.size-input'),
                    "weight": Number(fieldCheck(formEl, '.weight-input')),
                    "baseUnitType": unitType,
                    "unitPrice": Number(price),
                    "cuttingPrise": Number(fieldCheck(formEl, '.cutting-input'))
                }
                postRequestProcessing(item, className);
            }
            break;
    }
};

const fieldCheck = (formEl, className) => {
    const inputEl = formEl.querySelector(className);
    if (inputEl.value === "") {
        inputEl.classList.add('error');
        return false;
    } else {
        inputEl.classList.remove('error');
        return inputEl.value;
    }
};
// #endregion

// #region requests
const postRequestProcessing = (data, className) => {
    if (data) {
        postRequest(postUrl[className], data);
    }
};

const deleteRequestProcessing = (className, id) => {
    deleteRequest(`${delUrl[className]}${id}`);
};
// #endregion requests

// #region init
const catalogFilling = () => {
    const contentDiv = document.querySelector('.content');
    createUl(contentDiv, categories, "category", false);
};

const wait = () => {
    if (categories === null) {
        setTimeout(wait, 100);
    } else {
        catalogFilling();
    }
};

window.addEventListener('load', wait);
// #endregion init
