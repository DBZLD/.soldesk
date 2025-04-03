var arrCom = Array(6);
var arrPlayer = Array[6] = [6, 10, 19, 25, 40, 42];
var same = 0;



function setComNumber(){
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
}
function FindSame(){
    for(var i = 0; i < 6; i++){
        for(var j = 0; j < 6; j++){
            if(arrCom[i] == arrPlayer[j]){
                same += 1;
            }
        }
    }
}
function PrintPrice(){
    switch(same){
        case 0,1,2:
            alert("꽝입니다");
            break;
        case 3:
            alert("5등입니다.");
            break;
        case 4:
            alert("4등입니다.");
            break;
        case 5:
            alert("3등입니다");
            break;
        case 6:
            alert("1등입니다.");
            break;
    }
}
setComNumber();
FindSame();
PrintPrice();
