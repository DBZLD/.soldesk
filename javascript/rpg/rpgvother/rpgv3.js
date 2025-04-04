function Monster(name,hp,attack){
	this.name = name;
	this.hp = hp;
	this.attack = attack;	

	this.info = function(){
		document.write("이름"+this.name+" HP:"+this.hp+" 공격력:"+this.attack);
	}
}
function Character(){
	this.name;	
	this.hp;	
	this.attack;

	this.info = function(){
		document.write("이름 : "+this.name+" HP : " + this.hp + " 공격력 : " + this.attack);
	}
}
function getRandomAttackValue(attack){
	attack = attack + 1;				
	var random = Math.floor(Math.random()*attack);				
	return random;			
}		

var orc = new Monster("오크",100,10);

var elf = new Character();
elf.name = "엘프";
elf.hp = 200;
elf.attack = 20;

orc.info();
document.write("<br>");
document.write("<br>");
elf.info();

document.write("<hr>");
document.write("전투시작")
document.write("<hr>");

var elfdamage = getRandomAttackValue(elf.attack)
var orcdamage = getRandomAttackValue(orc.attack)
elf.hp -= orcdamage;
document.write(orc.name + "가 " + elf.name + "에게 데미지를 " + orcdamage + "만큼 입혔습니다.");
document.write("<br>");
document.write("<br>");
orc.hp -= elfdamage;
document.write(elf.name + "가 " + orc.name + "에게 데미지를 " + elfdamage + "만큼 입혔습니다.");
document.write("<br>");
document.write("<br>");

orc.info();
document.write("<br>");
document.write("<br>");
elf.info();


