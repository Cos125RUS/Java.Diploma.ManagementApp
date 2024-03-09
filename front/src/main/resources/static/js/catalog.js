// #region thymeleaf
// let categories = null;
// setTimeout(() => {
//     const data = document.querySelector("script.categories-data")
//     console.log(data);
//     // categories = JSON.parse(data.dataset.categories);
//     // console.log(categories);
// }, 100)
// #endregion

// #region models
const units = {
    kilogram: "кг",
    ton: "т",
    unit: "шт"
};

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
// let currentElementDiv = null;
// let currentElementView = null;

// // document.addEventListener('DOMContentLoaded', function (e) {
// //     currentElementDiv = document.querySelector('div.user-interface>div.user-interface__current-element');
// //     currentElementView = document.createElement('p');
// //     currentElementDiv.appendChild(currentElementView);
// // });

const catalogAddButton = document.querySelector('button.add-category-button');
catalogAddButton.addEventListener('click', function (e) {
    showAddInterface('catalog');
});

// #endregion

// #region catalogList
let categories = null;

document.addEventListener('DOMContentLoaded', function (e) {
    const url = "/api/catalog/category/findAll";
    const req = new XMLHttpRequest();
    req.open("GET", url);
    req.send();
    req.onreadystatechange = (e) => {
        try {
            categories = JSON.parse(req.responseText);
        } catch (error) {
            console.log(error);
        }
    };
});

const createUl = (parentElement, list, className, hidden) => {
    const ulElement = document.createElement('ul');
    parentElement.appendChild(ulElement);
    ulElement.classList.add(className);
    let liElement = null;
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
        console.log(className, element.id);
        // TODO: Add DELETE request
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
        pName.textContent = element.print + ' | ' + element.weight + ' | ' + element.unitPrice + 'р/' + units[element.baseUnitType];
        pName.addEventListener('click', function (e) {
            pName.classList.add(className);
        });
    }
    return liElement;
};

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
    // TODO: Add POST request
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
                postRequest({ "name": value }, className);
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
                postRequest(subcategory, className);
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
                postRequest(product, className);
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
                postRequest(item, className);
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

const postRequest = (data, className) => {
    if (data) {
        let url = null;
        switch (className) {
            case 'catalog':
                url = '/api/catalog/category/addCategory';
                break;
            case 'category':
                url = '/api/catalog/subcategory/addSubcategory';
                break;
            case 'subcategories':
                url = '/api/catalog/product/addProduct';
                break;
            case 'products':
                url = '/api/catalog/item/addItem';
                break;
        }
        fetch(url, {
            method: "POST",
            headers: {
                "Content-type": "application/json;charset=UTF-8"
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    window.location.reload();
                }
            });
    }
};

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
// #endregion

