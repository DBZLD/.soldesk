var arrCom = Array(6);

for(var i = 0; i < 6; i++){
    arrCom[i] = Math.floor(Math.random()*45)+1; 
    for(var j = 0; j < i; j++){
        while(true){
            if(arrCom[j] != arrCom[i]){
                break;
            }
            arrCom[i] = Math.floor(Math.random()*45)+1;
            j = 0; 
        }
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