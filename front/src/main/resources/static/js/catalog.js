// let categories = null;
// setTimeout(() => {
//     const data = document.querySelector("script.categories-data")
//     console.log(data);
//     // categories = JSON.parse(data.dataset.categories);
//     // console.log(categories);
// }, 1000)

let categories = null;
const units = {
    kilogram: "кг",
    ton: "т",
    unit: "шт"
};
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
    if (hidden) {
        ulElement.classList.add(hidden);
    }
    list.forEach(element => {
        ulElement.appendChild(createLi(element, className));
    });
};

const createLi = (element, className) => {
    const liElement = document.createElement('li');
    liElement.classList.add(className + '_' + element.id);
    const pName = document.createElement('p');
    liElement.appendChild(pName);
    if (Object.keys(element).indexOf('name') !== -1) {
        pName.textContent = element.name;
        let counter = 0;
        Object.values(element).forEach(value => {
            if (Array.isArray(value)) {
                createUl(liElement, value, Object.keys(element)[counter] + '_' + element.id, 'hidden');
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
