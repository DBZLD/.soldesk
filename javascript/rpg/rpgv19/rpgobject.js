function Character(name, hp, attack){
	this.name = name;
	this.maxHp = hp;
	this.nowHp = this.maxHp;
	this.attack = attack;
	this.needExp = 300;
	this.nowExp = 0;
	this.nowMoney = 0;

	this.Info = function(){
		stPlayer("[" + this.name+"(" + this.nowHp + "/" + this.maxHp + "] (exp : " + this.nowExp + "/" + this.needExp + ")");
	}
}
function Monster(name, hp, attack, exp, money){
	this.name = name;
	this.maxHp = hp;
	this.nowHp = this.maxHp;
	this.attack = attack;
	this.exp = exp;
	this.money = money;
	
	this.Info = function(){
		stObject("[" + this.name + "(" + this.nowHp + "/" + this.maxHp + ")]");
	}
}