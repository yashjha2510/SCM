console.log("script loaded");

let currentTheme = getTheme();
console.log(currentTheme);

const themeToggleBtn = document.querySelector("#theme-toggle");

// initial theme apply
applyTheme();

themeToggleBtn.addEventListener("click", () => {
    console.log("button clicked");

    // toggle theme
    currentTheme = currentTheme === "dark" ? "light" : "dark";

    // save theme
    setTheme(currentTheme);

    // apply theme
    applyTheme();
});

function applyTheme() {
    const html = document.documentElement;

    // remove old theme
    html.classList.remove("light", "dark");

    // add new theme
    html.classList.add(currentTheme);

    // update button text
    const span = themeToggleBtn.querySelector("span");
    if (span) {
        span.textContent = currentTheme === "light" ? "dark" : "light";
    }
}

// set theme to local storage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

// get theme from local storage
function getTheme() {
    const theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}