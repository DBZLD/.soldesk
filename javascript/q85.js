var getImgCat;
var getButtonCat;

var isPopup = false;

window.onload = function(){
    getImgCat = document.getElementById("imgCat");
    getButtonCat = document.getElementById("imgButton");
}

function Click(){
    if(isPopup == false){
        getImgCat.style.display = "inline";
        isPopup = true;
    }
    else if(isPopup == true){
        getImgCat.style.display = "none";
        isPopup = false;
    }
}