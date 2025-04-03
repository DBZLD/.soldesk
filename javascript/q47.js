function Cat(){
    this.name;
    this.age;
    this.weight;
    this.family;
    this.color;
}

var kitty = new Cat();
kitty.name = "야옹이";
kitty.age = 5;
kitty.weight = 4.1;
kitty.family = "코리안숏헤어";
kitty.color = "검은색";
document.write("이름 : " + kitty.name + '\n');
document.write("나이 : " + kitty.age + '\n');
document.write("몸무게 : " + kitty.weight + '\n');
document.write("종류 : " + kitty.family + '\n');
document.write("색 : " + kitty.color + '\n');