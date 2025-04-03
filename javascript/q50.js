function Monster(name, hp, attack){
    this.name;
    this.hp;
    this.attack;

    this.info = function(){
        document.write("이름 : " + name + '\n');
        document.write("체력 : " + hp + '\n');
        document.write("공격력 : " + attack + '\n');
    }
}
function Character(name, hp, attack){
    this.name;
    this.hp;
    this.attack;

    this.info = function(){
        document.write("이름 : " + name + '\n');
        document.write("체력 : " + hp + '\n');
        document.write("공격력 : " + attack + '\n');
    }
}

var orc = new Monster("오크", 100, 5);
var elf = new Character("엘프", 50, 10);

orc.info();
elf.info();