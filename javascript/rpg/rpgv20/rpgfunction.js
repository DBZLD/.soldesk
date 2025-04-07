//턴 진행 시
function TurnOver(){
	if(playerState == "전투"){
		player.Info();
		arrMonster.Info();
	}
	else if (playerState == "대기"){
		stRpg("대기중..");
		br(); br();
	}
	stTurn(nTurn);
	console.log("턴 진행");
}
// 랜덤 공격력 설정
function GetRandomAttackValue(attack){
	attack = attack + 1;				
	var random = Math.floor(Math.random()*attack);				
	return random;			
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
//동쪽 이동 클릭 시
function ClickMove(str){
	if(str == 'east'){
		if(GetNowRoom().eastRoomNum == 0){
			stRpg("동쪽으로 갈 수 없음");
			br(); br();
		}
		else {
			nowRoomNum = GetNowRoom().eastRoomNum;
			PrintRoomInfo();
			stRpg("동쪽으로 이동");
			hr();
			stRpg(GetNowRoom().name);
			hr();
			br(); br();
		}
	}
	else if(str == 'west'){
		if(GetNowRoom().westRoomNum == 0){
			stRpg("서쪽으로 갈 수 없음");
			br(); br();
		}
		else {
			nowRoomNum = GetNowRoom().westRoomNum;
			PrintRoomInfo();
			stRpg("서쪽으로 이동");
			hr();
			stRpg(GetNowRoom().name);
			hr();
			br(); br();
		}
	}
	else if(str == 'north'){
		if(GetNowRoom().northRoomNum == 0){
			stRpg("북쪽으로 갈 수 없음");
			br(); br();
		}
		else {
			nowRoomNum = GetNowRoom().northRoomNum;
			PrintRoomInfo();
			stRpg("북쪽으로 이동");
			hr();
			stRpg(GetNowRoom().name);
			hr();
			br(); br();
		}
	}
	else if(str == 'south'){
		if(GetNowRoom().southRoomNum == 0){
			stRpg("남쪽으로 갈 수 없음");
			br(); br();
		}
		else {
			nowRoomNum = GetNowRoom().southRoomNum;
			PrintRoomInfo();
			stRpg("남쪽으로 이동");
			hr();
			stRpg(GetNowRoom().name);
			hr();
			br(); br();
		}
	}
	FindMonster();
	stTurn(nTurn);
}
//자동 스크롤
function TextareaAutoScroll(){
    getRpgTextarea.scrollTop = getRpgTextarea.scrollHeight;
}
//현재 방 찾기
function GetNowRoom(){
	for(var i = 0; i < arrRoom.length; i++){
		if(arrRoom[i].number == nowRoomNum){
			return arrRoom[i];
		}
	}
}
function GetRoom(num){
	for(var i = 0; i < arrRoom.length; i++){
		if(arrRoom[i].number == num){
			return arrRoom[i];
		}
	}
}
//방 정보 출력
function PrintRoomInfo(){
	GetNowRoom().PrintRoomInfo();
}
function FindMonster(){
	nowMonster = null;
	for (var i = 0; i < arrMonster.length; i++){
		if(arrMonster[i].location == GetNowRoom().number){
			nowMonster = arrMonster[i];
		}
	}
	if(nowMonster != null){
		nowMonster.Info();
	}
	else {
		stObject("");
	}
}