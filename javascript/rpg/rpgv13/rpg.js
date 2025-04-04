var orc = new Monster("오크", 100, 10);
var elf = new Character("엘프", 200, 10);

var getRpgTextarea;
var getPlayerTextarea;
var getObjectTextarea;
var getTurnText;
var stRpgTextarea = "";
var stPlayerTextarea = "";
var stObjectTextarea = "";
var nTurn = 0;
var isFight;

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
	isFight = true;
}

function SkipTurn(){
	if(isFight == true){
		if (elf.nowHp <= 0 || orc.nowHp <= 0) {
			elf.nowExp += 100;
			stRpg(orc.name + "가 " + elf.name + "에게 경험치를 " + "100만큼 줬습니다.");
			br();
			elf.nowMoney += 10;
			elf.Info();
			hr();
			stRpg("전투 종료");
			hr();
			isFight = false;

		}
	PrintFightInfo();
	br();
	}
	nTurn++;
	console.log("턴 진행");
	getTurnText.value = nTurn + "턴";
}
function GetRandomAttackValue(attack){
	attack = attack + 1;				
	var random = Math.floor(Math.random()*attack);				
	return random;			
}	
function PrintInfo(){
	elf.Info();
	if(orc.nowHp > 0){
		orc.Info();
	}
	else {
		getObjectTextarea.value = "";
	}
}
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
