// let categories = null;
// setTimeout(() => {
//     const data = document.querySelector("script.categories-data")
//     console.log(data);
//     // categories = JSON.parse(data.dataset.categories);
//     // console.log(categories);
// }, 1000)

let categories = null;
window.addEventListener('load', function (e) {
    const url = "/api/catalog/category/findAll";
    const req = new XMLHttpRequest();
    req.open("GET", url);
    req.send(null);
    req.onreadystatechange = (e) => {
        try {
            categories = JSON.parse(req.responseText);
        } catch (error) {
            // console.log(error);
        }
    }
});

const createUl = (parentElement, list) => {
    const ulElement = document.createElement('ul');
    parentElement.appendChild(ulElement);
    list.forEach(element => {
        ulElement.appendChild(createLi(element));
    });
};

const createLi = (element) => {
    const liElement = document.createElement('li');
    const pName = document.createElement('p');
    pName.textContent = element.name;
    liElement.appendChild(pName);
    Array.from(Object.values(element)).forEach(values => {
        if (Array.isArray(values)) {
            createUl(liElement, values);
        }
    });
    return liElement;
};

const catalogFilling = () => {
    console.log(categories);

    const contentDiv = document.querySelector('.content');
    createUl(contentDiv, categories);
};

const wait = () => {
    if (categories === null) {
        setTimeout(wait, 100);
    } else {
        catalogFilling();
    }
};

wait();