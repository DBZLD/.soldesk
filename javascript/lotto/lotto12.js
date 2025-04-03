var arrCom = Array(6);
var bonusComNum;
var arrPlayer = Array[6] = [6, 10, 19, 25, 40, 42];
var bonusPlayer = 9;
var sameNum = 0;
var bonusSame;
var numberTextEx = "";

function SetComNumber(){
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
    bonusComNum = Math.floor(Math.random()*45)+1;
    for(var i = 0; i < 6; i++){
        while(true){
            if(bonusComNum != arrCom[i]){
                break;
            }
            bonusComNum = Math.floor(Math.random()*45)+1;
            j = 0;
        }
    }
}

function FindSame(){
    for(var i = 0; i < 6; i++){
        for(var j = 0; j < 6; j++){
            if(arrCom[i] == arrPlayer[j]){
                sameNum += 1;
            }
        }
    }
    if(bonusComNum == bonusPlayer){
        bonusSame = true;
    }
    else{
        bonusSame = false;
    }
}

function PrintPrice(){
    switch(sameNum){
        case 0:
        case 1:
        case 2:
            alert("꽝입니다");
            break;
        case 3:
            alert("5등입니다.");
            break;
        case 4:
            alert("4등입니다.");
            break;
        case 5:
            if(bonusSame == true){
                alert("2등입니다");
            }
            else{
                alert("3등입니다");
            }
            break;
        case 6:
            alert("1등입니다.");
            break;
    }
}
function PrintNumber(){
    numberTextEx = "당첨 번호 : ";
    for(var i = 0; i < 6; i++){
        numberTextEx += arrCom[i]+", ";
    }
    numberTextEx+= "보너스 번호 : " + bonusComNum;
    numberTextEx += '\n' + "나의 번호 : ";
    for(var i = 0; i < 6; i++){
        numberTextEx += arrPlayer[i]+", ";
    }
    numberTextEx += "보너스 번호 : " + bonusPlayer;
    alert(numberTextEx);

}
SetComNumber();
FindSame();
PrintNumber();
PrintPrice();