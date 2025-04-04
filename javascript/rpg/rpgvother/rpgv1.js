function Monster(name, hp, attack){
    this.name;
    this.hp;
    this.attack;

    this.info = function(){
        document.write("이름 : " + name);
        document.write("&nbsp;&nbsp;체력 : " + hp);
        document.write("&nbsp;&nbsp;공격력 : " + attack);
        br();
    }
}
function Character(name, hp, attack){
    this.name;
    this.hp;
    this.attack;

    this.info = function(){
        document.write("이름 : " + name);
        document.write("&nbsp;&nbsp;체력 : " + hp);
        document.write("&nbsp;&nbsp;공격력 : " + attack);
        br();
    }
}

var orc = new Monster("오크", 100, 5);
var elf = new Character("엘프", 50, 10);

orc.info();
elf.info();