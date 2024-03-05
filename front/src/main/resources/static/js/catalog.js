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
let currentElementDiv = null;
let currentElementView = null;

document.addEventListener('DOMContentLoaded', function (e) {
    currentElementDiv = document.querySelector('div.user-interface>div.user-interface__current-element');
    currentElementView = document.createElement('p');
    currentElementDiv.appendChild(currentElementView);
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
    ulElement.addEventListener('click', function (e) {
        e.stopPropagation();
        try {
            if (e.target.nextElementSibling.classList.contains('hidden')) {
                e.target.nextElementSibling.classList.remove('hidden');
                currentElement[e.target.dataset.catalogType].id = e.target.dataset.id;
                currentElement[e.target.dataset.catalogType].name = e.target.innerHTML;
                console.log(e.target.dataset.catalogType);
                switch (e.target.dataset.catalogType) {
                    case 'category':
                        currentElementView.innerHTML = currentElement.category.name;
                        break;
                    case 'subcategories':
                        currentElementView.innerHTML += ">" + currentElement.subcategories.name;
                        break;
                    case 'products':
                        currentElementView.innerHTML += ">" + currentElement.products.name;
                        break;
                }
            } else {
                e.target.nextElementSibling.classList.add('hidden');
            }
        } catch (error) {
            console.log(error);
        }
    });
    if (hidden) {
        ulElement.classList.add(hidden);
    }
    list.forEach(element => {
        ulElement.appendChild(createLi(element, className));
    });
};

const createLi = (element, className) => {
    const liElement = document.createElement('li');
    // liElement.classList.add(className + '_' + element.id);
    liElement.classList.add(className);
    const pName = document.createElement('p');
    liElement.appendChild(pName);
    if (Object.keys(element).indexOf('name') !== -1) {
        pName.textContent = element.name;
        pName.dataset.id = element.id;
        pName.dataset.catalogType = className;
        let counter = 0;
        Object.values(element).forEach(value => {
            if (Array.isArray(value)) {
                // createUl(liElement, value, Object.keys(element)[counter] + '_' + element.id, 'hidden');
                createUl(liElement, value, Object.keys(element)[counter], 'hidden');
            }
            counter++;
        });
    } else if (Object.keys(element).indexOf('print') !== -1) {
        pName.textContent = element.print + ' | ' + element.weight + ' | ' + element.unitPrice + 'р/' + units[element.baseUnitType];
    }
    return liElement;
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

