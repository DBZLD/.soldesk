var getPopupButton;

window.onload = function(){
    getPopupButton = document.getElementById("popupBox")
}

function PopupButtonClick(){
    getPopupButton.style.background = "orange";
    getPopupButton.style.width = "200px";
    getPopupButton.style.height = "200px";
    getPopupButton.style.transitionDuration = "2s";
}