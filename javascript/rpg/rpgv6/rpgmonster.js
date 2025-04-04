function Monster(name,hp,attack){
	this.name = name;
	this.maxHp = hp;
	this.nowHp = this.maxHp;
	this.attack = attack;	

	this.Info = function(){
		document.write("[" + this.name+"("+this.nowHp + "/"+this.maxHp + "]");
	}
}