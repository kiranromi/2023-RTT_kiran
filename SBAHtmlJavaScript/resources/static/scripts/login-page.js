
const loginForm = document.getElementById("loginForm");
const loginButton = document.getElementById("submitbutton");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.email.value;
    const password = loginForm.psw.value;

    if (username === "kiran.romi@gmail.com" && password === "password") {
        alert("You have successfully logged in.");
        location.reload();
    } else {
        loginErrorMsg.style.opacity = 1;
    }
})