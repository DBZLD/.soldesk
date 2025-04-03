function Cat(){
    this.name;
    this.age;
    this.weight;
    this.family;
    this.color;

    this.compareAge = function(a, b){
        if(a.age>b.age){
            document.write("형님고양이 : "+ a.name + '\n');
            document.write("동생고양이 : "+ b.name + '\n');
        }
        else if(a.age<b.age){
            document.write("형님고양이 : "+ b.name + '\n');
            document.write("동생고양이 : "+ a.name + '\n');
        }
        else{
            document.write("둘은 친구임");
        }
    }
}

var kitty = new Cat();
var yaongi = new Cat();

kitty.name = "야옹이";
kitty.age = 5;
kitty.weight = 4.1;
kitty.family = "코리안숏헤어";
kitty.color = "검은색";

yaongi.name = "키티";
yaongi.age = 7;
yaongi.weight = 3;
yaongi.family = "페르시안";
yaongi.color = "하얀색";

kitty.compareAge(kitty, yaongi);