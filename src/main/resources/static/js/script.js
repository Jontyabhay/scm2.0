console.log("Script loaded");

//change theme work
let currentTheme = getTheme();
changeTheme();


//TODO;
function changeTheme(){
    document.querySelector("html").classList.add(currentTheme);

    //set the listener
    let changeThemeButton = document.querySelector('#theme_change_button');
    let oldTheme=currentTheme;
    changeThemeButton.addEventListener('click', (event) => {
        console.log("Theme button clicked");
        document.querySelector("html").classList.remove(currentTheme);
        if (currentTheme == "dark"){
            currentTheme="light";
        }
        else{
            currentTheme="dark";
        }
        setTheme(currentTheme);
        document.querySelector("html").classList.remove(oldTheme);
        document.querySelector("html").classList.add(currentTheme);

        changeThemeButton.querySelector('span').textContent = currentTheme == 'light'?'Dark':'Light';
    });
}

//set theme to localstorage

function setTheme(theme){
    localStorage.setItem("theme", theme);
}

//get theme from localstorage

function getTheme(){
    let theme=localStorage.getItem("theme");
    return theme ? theme : "light";
}