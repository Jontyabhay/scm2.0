console.log("Script loaded");

let currentTheme = getTheme();
changeTheme();


//TODO;
function changeTheme(){
    document.querySelector("html").classList.add(currentTheme);

    //set the listener
    const changeThemeButton = document.querySelector('#theme_change_button');
    changeThemeButton.addEventListener('click', (event) => {
        const oldTheme=currentTheme;
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