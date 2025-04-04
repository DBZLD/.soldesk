
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

elf.hp = elf.hp - orc.attack;
orc.hp = orc.hp - elf.attack;

orc.info();
document.write("<br>");
document.write("<br>");
elf.info();


