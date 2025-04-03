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
    if(Com3 != Com2 && Com3 != Com1){
        break;
    }
}
Com4 = Math.floor(Math.random()*45)+1;
Com5 = Math.floor(Math.random()*45)+1;
Com6 = Math.floor(Math.random()*45)+1;

var Player1 = 10;
var Player2 = 6;
var Player3 = 35;
var Player4 = 23;
var Player5 = 19;
var Player6 = 40;

var same = 0;

if(Com1 == Player1){
    same += 1;
}
if(Com1 == Player2){
    same += 1;
}
if(Com1 == Player3){
    same += 1;
}
if(Com1 == Player4){
    same += 1;
}
if(Com1 == Player5){
    same += 1;
}
if(Com1 == Player6){
    same += 1;
}
if(Com2 == Player1){
    same += 1;
}
if(Com2 == Player2){
    same += 1;
}
if(Com2 == Player3){
    same += 1;
}
if(Com2 == Player4){
    same += 1;
}
if(Com2 == Player5){
    same += 1;
}
if(Com2 == Player6){
    same += 1;
}
if(Com3 == Player1){
    same += 1;
}
if(Com3 == Player2){
    same += 1;
}
if(Com3 == Player3){
    same += 1;
}
if(Com3 == Player4){
    same += 1;
}
if(Com3 == Player5){
    same += 1;
}
if(Com3 == Player6){
    same += 1;
}
if(Com4 == Player1){
    same += 1;
}
if(Com4 == Player2){
    same += 1;
}
if(Com4 == Player3){
    same += 1;
}
if(Com4 == Player4){
    same += 1;
}
if(Com4 == Player5){
    same += 1;
}
if(Com4 == Player6){
    same += 1;
}
if(Com5 == Player1){
    same += 1;
}
if(Com5 == Player2){
    same += 1;
}
if(Com5 == Player3){
    same += 1;
}
if(Com5 == Player4){
    same += 1;
}
if(Com5 == Player5){
    same += 1;
}
if(Com5 == Player6){
    same += 1;
}
if(Com6 == Player1){
    same += 1;
}
if(Com6 == Player2){
    same += 1;
}
if(Com6 == Player3){
    same += 1;
}
if(Com6 == Player4){
    same += 1;
}
if(Com6 == Player5){
    same += 1;
}
if(Com6 == Player6){
    same += 1;
}

alert(same);