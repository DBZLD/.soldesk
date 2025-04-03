var Com1;
var Com2;
var Com3;
var Com4;
var Com5;
var Com6;

Com1 = Math.floor(Math.random()*45)+1;

while(true){
    Com2 = Math.floor(Math.random()*45)+1;
    if(Com2 != Com1){
        break;
    }
}
while(true){
    Com3 = Math.floor(Math.random()*45)+1;
    if(Com3 != Com1 && Com3 != Com2){
        break;
    }
}
while(true){
    Com4 = Math.floor(Math.random()*45)+1;
    if(Com4 != Com1 && Com4 != Com2 && Com4 != Com3){
        break;
    }
}
while(true){
    Com5 = Math.floor(Math.random()*45)+1;
    if(Com5 != Com1 && Com5 != Com2 && Com5 != Com3 && Com5 != Com4){
        break;
    }
}
while(true){
    Com6 = Math.floor(Math.random()*45)+1;
    if(Com6 != Com1 && Com6 != Com2 && Com6 != Com3 && Com6 != Com4 && Com6 != Com5){
        break;
    }
}

var arrPlayer = Array[6] = [6, 10, 19, 25, 40, 42];

var same = 0;

for(var i = 0; i < 6; i++){
    if(Com1 == arrPlayer[i]){
        same += 1;
    }
}
for(var i = 0; i < 6; i++){
    if(Com2 == arrPlayer[i]){
        same += 1;
    }
}
for(var i = 0; i < 6; i++){
    if(Com3 == arrPlayer[i]){
        same += 1;
    }
}
for(var i = 0; i < 6; i++){
    if(Com4 == arrPlayer[i]){
        same += 1;
    }
}
for(var i = 0; i < 6; i++){
    if(Com5 == arrPlayer[i]){
        same += 1;
    }
}
for(var i = 0; i < 6; i++){
    if(Com6 == arrPlayer[i]){
        same += 1;
    }
}

alert(same);