function br(){
    stRpgTextarea += "\n";
    getRpgTextarea.value = stRpgTextarea;
    TextareaAutoScroll()
}
function hr(){
    stRpgTextarea += "\n------------------------------------------------------\n"
    getRpgTextarea.value = stRpgTextarea;
    TextareaAutoScroll()
}
function stRpg(str){
    stRpgTextarea += str;
    getRpgTextarea.value = stRpgTextarea;
    TextareaAutoScroll();
}
function stPlayer(str){
    getPlayerTextarea.value = "";
    getPlayerTextarea.value = str;
}
function stObject(str){
    getObjectTextarea.value = "";
    getObjectTextarea.value = str;
}
function stRoom(str){
    getRoomTextarea.value = "";
    getRoomTextarea.value = str;
}
function stTurn(str){
    getTurnText.value = "";
    nTurn++;
    getTurnText.value = str + "턴";
}