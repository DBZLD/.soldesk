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
    for(var j = 0; j < 6; j++){
        if(arrCom[i] == arrPlayer[j]){
            same += 1;
        }
    }
}
alert(same);