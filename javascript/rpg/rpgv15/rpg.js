var orc = new Monster("몬스터", 100, 10);
var elf = new Character("플레이어", 200, 10);

var getRpgTextarea;
var getPlayerTextarea;
var getObjectTextarea;
var getTurnText;
var stRpgTextarea = "";
var stPlayerTextarea = "";
var stObjectTextarea = "";
var nTurn = 0;
var playerState = "대기";

window.onload = function() {
	getRpgTextarea = document.getElementById("rpgScreen");
	getPlayerTextarea = document.getElementById("playerScreen");
	getObjectTextarea = document.getElementById("objectScreen");
	getTurnText = document.getElementById("turnText");

	getTurnText.value = nTurn + "턴";
	PrintInfo();

	hr();
	stRpg("전투 시작");
	hr();
	playerState = "전투";
}