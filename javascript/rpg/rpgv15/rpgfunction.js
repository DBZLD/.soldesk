//턴 진행 시
function TurnOver(){
	if(playerState == "전투"){
		PrintFightInfo();
		br();
		if (elf.nowHp <= 0 || orc.nowHp <= 0) {
			elf.nowExp += 100;
			stRpg(orc.name + "가 " + elf.name + "에게 경험치를 " + "100만큼 줬습니다.");
			br();
			elf.nowMoney += 10;
			elf.Info();
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
	nTurn++;
	console.log("턴 진행");
	getTurnText.value = nTurn + "턴";
}
// 랜덤 공격력 설정
function GetRandomAttackValue(attack){
	attack = attack + 1;				
	var random = Math.floor(Math.random()*attack);				
	return random;			
}
// 정보 화면 출력
function PrintInfo(){
	elf.Info();
	if(orc.nowHp > 0){
		orc.Info();
	}
	else {
		getObjectTextarea.value = "";
	}
}
// 전투 화면 출력
function PrintFightInfo(){
	var elfdamage = GetRandomAttackValue(elf.attack);
	var orcdamage = GetRandomAttackValue(orc.attack);
	elf.nowHp -= orcdamage;
	orc.nowHp -= elfdamage;
	stRpg(elf.name + "가 " + orc.name + "에게 데미지를 " + elfdamage + "만큼 입혔습니다.");
	br(); br();
	stRpg(orc.name + "가 " + elf.name + "에게 데미지를 " + orcdamage + "만큼 입혔습니다.");
	br(); br();
	PrintInfo();
}
function clickMoveEast(){
	stRpg("동쪽으로 이동");
	br();
	nTurn++;
	getTurnText.value = nTurn + "턴";
}
function clickMoveWest(){
	stRpg("서쪽으로 이동");
	br();
	nTurn++;
	getTurnText.value = nTurn + "턴";
}
function clickMoveSouth(){
	stRpg("남쪽으로 이동");
	br();
	nTurn++;
	getTurnText.value = nTurn + "턴";
}
function clickMoveNorth(){
	stRpg("북쪽으로 이동");
	br();
	nTurn++;
	getTurnText.value = nTurn + "턴";
}
//자동 스크롤
function screenMessageBoxScrollToBot(){
    getRpgTextarea.scrollTop = getRpgTextarea.scrollHeight;
}