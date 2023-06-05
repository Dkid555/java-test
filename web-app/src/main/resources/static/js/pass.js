const form = document.querySelector("form");
const btn = document.querySelector("button");
const inputs = document.querySelectorAll("input");
const login = document.querySelector("input[name=login]");
const password = document.querySelector("input[name=password]");

const registeredUsers = [
    ["admin", "KoI18"],
    ["manager", "SuperMe108"],
    ["editor", "12345"],
    ["root", "root"],
];

function isValid(username, password) {
    for (var i = 0; i < registeredUsers.length; i++) {
        var temp = registeredUsers[i];
        if (temp[0] == username) {
            var currentPair = temp;
            break;
        }
    }
    if (currentPair && currentPair[1] == password) {
        return true;
    } else {
        return false;
    }
}

form.addEventListener('submit', function (e) {
    e.preventDefault();
    var username = inputs["login"].value;
    var password = inputs["password"].value;
    if (!isValid(username, password)) {
        alert('Неверный логин или пароль');
    } else {
        alert('Верные данные');
    }
});