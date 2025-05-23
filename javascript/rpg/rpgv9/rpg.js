var orc = new Monster("오크", 100, 10);
var elf = new Character("엘프", 200, 10);

var getRpgTextarea;
var stRpgTextarea = "";

window.onload = function() {
	getRpgTextarea = document.getElementById("rpgScreen");

	PrintInfo();

	hr();
	stSet("전투 시작");
	hr();

	while(true){
		if(elf.nowHp <= 0 || orc.nowHp <= 0){
			elf.nowExp += 100;
			stSet(orc.name + "가 " + elf.name + "에게 경험치를 " + "100만큼 줬습니다.");
			br();
			elf.nowMoney += 10;
			stSet(elf.Info());
			hr();
			stSet("전투 종료");
			hr();
			break;
		}
		PrintFightInfo();
		br();
	}
}

function GetRandomAttackValue(attack){
	attack = attack + 1;				
	var random = Math.floor(Math.random()*attack);				
	return random;			
}	
function PrintInfo(){
	stSet(elf.Info());
	stSet(orc.Info());
}
function PrintFightInfo(){
	var elfdamage = GetRandomAttackValue(elf.attack);
	var orcdamage = GetRandomAttackValue(orc.attack);
	elf.nowHp -= orcdamage;
	orc.nowHp -= elfdamage;
	stSet(elf.name + "가 " + orc.name + "에게 데미지를 " + elfdamage + "만큼 입혔습니다.");
	br(); br();
	stSet(orc.name + "가 " + elf.name + "에게 데미지를 " + orcdamage + "만큼 입혔습니다.");
	br(); br();
	PrintInfo();
}
