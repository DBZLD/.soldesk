function br(){
    stRpgTextarea += "\n";
    getRpgTextarea.value = stRpgTextarea;
    screenMessageBoxScrollToBot()
}
function hr(){
    stRpgTextarea += "\n------------------------------------------------------\n"
    getRpgTextarea.value = stRpgTextarea;
    screenMessageBoxScrollToBot()
}
function stRpg(str){
    stRpgTextarea += str;
    getRpgTextarea.value = stRpgTextarea;
    screenMessageBoxScrollToBot()
}
function stPlayer(str){
    getPlayerTextarea.value = "";
    getPlayerTextarea.value = str;
    screenMessageBoxScrollToBot()
}
function stObject(str){
    getObjectTextarea.value = "";
    getObjectTextarea.value = str;
    screenMessageBoxScrollToBot()
}