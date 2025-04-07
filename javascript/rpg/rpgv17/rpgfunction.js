//턴 진행 시
function TurnOver(){
	if(playerState == "전투"){
		PrintFightInfo();
		br();
		if (player.nowHp <= 0 || goblin.nowHp <= 0) {
			player.nowExp += 100;
			stRpg(goblin.name + "가 " + player.name + "에게 경험치를 " + "100만큼 줬습니다.");
			br();
			player.nowMoney += 10;
			player.Info();
			hr();
			stRpg("전투 종료");
			hr();
			playerState = "대기";
		}
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
	if(goblin.nowHp > 0){
		goblin.Info();
	}
	else {
		getObjectTextarea.value = "";
	}
}
// 전투 화면 출력
function PrintFightInfo(){
	var playerDamage = GetRandomAttackValue(player.attack);
	var goblinDamage = GetRandomAttackValue(goblin.attack);
	player.nowHp -= goblinDamage;
	goblin.nowHp -= elfDamage;
	stRpg(player.name + "가 " + goblin.name + "에게 데미지를 " + playerDamage + "만큼 입혔습니다.");
	br(); br();
	stRpg(goblin.name + "가 " + elf.name + "에게 데미지를 " + goblinDamage + "만큼 입혔습니다.");
	br(); br();
	PrintInfo();
}
//동쪽 이동 클릭 시
function ClickMove(){
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