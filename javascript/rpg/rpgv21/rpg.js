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
	new Room(3, "로비", "...", 0, 2, 6, 4),
	new Room(4, "고블린 서식지", "고블린이 나타난다.", 7, 0, 3, 5),
	new Room(5, "고블린 서식지 깊은 곳", "더 강한 고블린이 나타난다.", 0, 0, 4, 0),
	new Room(6, "초급 훈련장", "훈련할 수 있다.", 0, 0, 0, 3),
	new Room(7, "오크 서식지", "오크가 나타난다.", 0, 4, 0, 0)
];
var nowRoomNum = 1;
var arrMonster = [
	new Monster("허수아비", 100, 0, 0, 0, 6),
	new Monster("고블린", 40, 5, 1, 1, 4),
	new Monster("정예 고블린", 60, 10, 5, 5, 5),
	new Monster("오크", 50, 7, 3, 3, 7)
];
var nowMonster;

window.onload = function() {
	getRpgTextarea = document.getElementById("rpgScreen");
	getPlayerTextarea = document.getElementById("playerScreen");
	getObjectTextarea = document.getElementById("objectScreen");
	getRoomTextarea = document.getElementById("roomScreen");
	getTurnText = document.getElementById("turnText");

	stTurn(nTurn);
	PrintRoomInfo();
	player.Info();
}