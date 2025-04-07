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
	new Room(0, "벽", "지나갈 수 없다.", 0, 0, 0, 0),
	new Room(1, "입구", "...", 2, 0, 0, 0),
	new Room(2, "동쪽 복도", "...", 3, 1, 0, 0),
	new Room(3, "로비", "...", 0, 2, 4, 6),
	new Room(4, "고블린 서식지", "고블린이 나타난다.", 0, 2, 5, 3),
	new Room(5, "고블린 서식지 깊은 곳", "더 강한 고블린이 나타난다.", 0, 2, 0, 4),
	new Room(6, "훈련장", "모의 전투를 할 수 있다.", 0, 0, 3, 0)
];
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