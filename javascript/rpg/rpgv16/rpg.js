var orc = new Monster("몬스터", 100, 10);
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
var roomA = new Room(1, "start", "출발 지점", 3, 0, 2, 0);
var roomB = new Room(2, "north room", "북쪽 지점", 0, 0, 0, 1);
var roomC = new Room(3, "east room", "동쪽 지점", 0, 1, 0, 0);

window.onload = function() {
	getRpgTextarea = document.getElementById("rpgScreen");
	getPlayerTextarea = document.getElementById("playerScreen");
	getObjectTextarea = document.getElementById("objectScreen");
	getRoomTextarea = document.getElementById("roomScreen");
	getTurnText = document.getElementById("turnText");

	getTurnText.value = nTurn + "턴";
	roomA.PrintRoomInfo();
}