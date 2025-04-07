var goblin = new Monster("몬스터", 100, 10);
var player = new Character("플레이어", 200, 10);

var getRpgTextarea;
var getPlayerTextarea;
var getObjectTextarea;
var getRoomTextarea;
var getTurnText;
var stRpgTextarea = "";
var stPlayerTextarea = "";
var stObjectTextarea = "";
var nTurn = 1;
var playerState = "대기";
var arrRoom = [
	new Room(0, "벽", "벽", 0, 0, 0, 0),
	new Room(1, "start", "출발 지점", 2, 0, 0, 0),
	new Room(2, "east room", "동쪽 지점", 3, 1, 0, 0),
	new Room(3, "center room", "중앙 지점", 0, 2, 0, 0)];
var nowRoomNum = 1;

window.onload = function() {
	getRpgTextarea = document.getElementById("rpgScreen");
	getPlayerTextarea = document.getElementById("playerScreen");
	getObjectTextarea = document.getElementById("objectScreen");
	getRoomTextarea = document.getElementById("roomScreen");
	getTurnText = document.getElementById("turnText");

	stTurn(nTurn);
	PrintRoomInfo();
}