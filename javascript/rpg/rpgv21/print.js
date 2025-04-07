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
// 정보 화면 출력
function PrintInfo(){
	player.Info();
}
// 전투 화면 출력
function PrintFightInfo(){
	// var playerDamage = GetRandomAttackValue(player.attack);
	// var goblinDamage = GetRandomAttackValue(goblin.attack);
	// player.nowHp -= goblinDamage;
	// goblin.nowHp -= elfDamage;
	// stRpg(player.name + "가 " + goblin.name + "에게 데미지를 " + playerDamage + "만큼 입혔습니다.");
	// br(); br();
	// stRpg(goblin.name + "가 " + elf.name + "에게 데미지를 " + goblinDamage + "만큼 입혔습니다.");
	// br(); br();
	// PrintInfo();
}
//방 정보 출력
function PrintRoomInfo(){
	GetNowRoom().PrintRoomInfo();
}
//rpg 제외 창 클리어
function ClearSt(){
    getTurnText.value = "";
    getRoomTextarea.value = "";
    getObjectTextarea.value = "";
    getPlayerTextarea.value = "";
}