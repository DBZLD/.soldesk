var orc = new Monster("오크", 100, 10);
var elf = new Character("엘프", 200, 10);

PrintInfo();

document.write("<hr>");
document.write("전투시작")
document.write("<hr>");

var elfdamage = GetRandomAttackValue(elf.attack)
var orcdamage = GetRandomAttackValue(orc.attack)
elf.nowHp -= orcdamage;
orc.nowHp -= elfdamage;
document.write(elf.name + "가 " + orc.name + "에게 데미지를 " + elfdamage + "만큼 입혔습니다.");
document.write("<br>");
document.write("<br>");
document.write(orc.name + "가 " + elf.name + "에게 데미지를 " + orcdamage + "만큼 입혔습니다.");
document.write("<br>");
document.write("<br>");

PrintInfo();

function GetRandomAttackValue(attack){
	attack = attack + 1;				
	var random = Math.floor(Math.random()*attack);				
	return random;			
}	
function PrintInfo(){
	elf.Info();
	br(); br();
	orc.Info();
}
