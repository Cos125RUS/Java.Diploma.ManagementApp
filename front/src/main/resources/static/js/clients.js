let clients = null;

const clientType = {
    ie: "ИП",
    llc: "ООО",
    jsc: "ОАО",
    pp: "частное лицо"
}

document.addEventListener('DOMContentLoaded', function (e) {
    const url = "/api/clients/findAll";
    const req = new XMLHttpRequest();
    req.open("GET", url);
    req.send();
    req.onreadystatechange = (e) => {
        try {
            clients = JSON.parse(req.responseText);
        } catch (error) {
            console.log(error);
        }
    };
});

const clientsPageFilling = () => {
    const contentDiv = document.querySelector('.content');
    console.log(clients);
};

const wait = () => {
    if (clients === null) {
        setTimeout(wait, 100);
    } else {
        clientsPageFilling();
    }
};

window.addEventListener('load', wait);