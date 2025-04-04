function br(){
    stRpgTextarea += "\n";
    getRpgTextarea.value = stRpgTextarea;
}
function hr(){
    stRpgTextarea += "\n------------------------------------------------------\n"
    getRpgTextarea.value = stRpgTextarea;
}
function stRpg(str){
    stRpgTextarea += str;
    getRpgTextarea.value = stRpgTextarea;
}
function stPlayer(str){
    getPlayerTextarea.value = "";
    getPlayerTextarea.value = str;
}
function stObject(str){
    getObjectTextarea.value = "";
    getObjectTextarea.value = str;
}