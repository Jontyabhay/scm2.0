console.log("Script loaded");

let currentTheme="light";


//TODO;
function changeTheme(){

}

//set theme to localstorage

function setTheme(theme){
    localStorage.setItem("theme", theme);

}

//get theme from localstorage

function getTheme(){
    let theme=localStorage.getItem("theme");
    if(theme) return theme;
    else return "light";
}