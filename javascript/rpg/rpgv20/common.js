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
    getPlayerTextarea.value = str;
}
function stObject(str){
    getObjectTextarea.value = str;
}
function stRoom(str){
    getRoomTextarea.value = str;
}
function stTurn(str){
    nTurn++;
    getTurnText.value = str + "턴";
}
function clearSt(){
    getTurnText.value = "";
    getRoomTextarea.value = "";
    getObjectTextarea.value = "";
    getPlayerTextarea.value = "";
}