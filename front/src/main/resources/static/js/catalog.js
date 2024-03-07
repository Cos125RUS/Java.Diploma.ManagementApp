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
    req.send(null);
    req.onreadystatechange = (e) => {
        try {
            categories = JSON.parse(req.responseText);
        } catch (error) {
            console.log(error);
        }
    }
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
            console.log('catalog');
            addForm.appendChild(createInputField('Категория:', 'category-input'));
            break;
        case 'category':
            console.log('category', id);
            addForm.appendChild(createInputField('Подкатегория:', 'subcategory-input'));
            break;
        case 'subcategories':
            console.log('subcategory', id);
            addForm.appendChild(createInputField('Позиция:', 'product-input'));
            break;
        case 'products':
            console.log('product', id);
            addForm.appendChild(createInputField('Отображение:','print-input'));
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
    switch (className) {
        case 'catalog':
            const value = fieldCheck(formEl, '.category-input');
            if (value) {
                console.log(value);
                
            }
            break;
        case 'category':
            
            break;
        case 'subcategories':
            
            break;
        case 'products':
        
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

