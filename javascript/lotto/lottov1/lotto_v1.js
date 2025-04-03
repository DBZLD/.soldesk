var arrComNum = Array(6);
var bonusComNum;
var arrPlayerNum = Array(6);
var bonusSame;
var sameNum = 0;
var isError;

var getMyNum;
var getLottoScreen;
var getResultScreen;
var getResultBall;
var getResultPrice;

window.onload = function(){
    getMyNum = document.getElementsByClassName("inputLottoNum");
    getLottoScreen = document.getElementById("lottoScreen");
    getResultScreen = document.getElementById("resultScreen");
    getResultBall = document.getElementsByClassName("resultBall");
    getResultPrice = document.getElementById("resultPriceScreen");
}

//버튼 클릭 이벤트
function RollLotto(){
    isError = false;

    for(var i = 0; i < getMyNum.length; i++){
        if(isError == true) { break; }
            arrPlayerNum[i] = getMyNum[i].value;
        for(var j = 0; j < i; j++){
            if(isError == true) { break; }
            while(true){
                if(isError == true) { break; }
                if(getMyNum[i].value == 0 || getMyNum[i].value == null){
                        alert("번호를 입력하지 않았습니다");
                        isError = true;
                        break;
                }
                if(!(getMyNum[i].value >= 1 && getMyNum[i].value <= 45)){
                    alert("잘못된 값을 입력했습니다.");
                    isError = true;
                    break;
                }
                if(getMyNum[j].value != getMyNum[i].value){
                    break;
                }
                alert("중복된 번호가 존재합니다.");
                isError = true;
                break;
            }
        }
    }
    if(isError == true) { return; }

    SetComNumber();
    FindSame();
    getLottoScreen.style.display = "none";
    getResultScreen.style.display = "flex";
    SetResultBall();
    SetResultPrice();
}
//컴퓨터 랜덤 번호 만들기
function SetComNumber(){
    for(var i = 0; i < 6; i++){
        arrComNum[i] = Math.floor(Math.random()*45)+1; 
        for(var j = 0; j < i; j++){
            while(true){
                if(arrComNum[j] != arrComNum[i]){
                    break;
                }
                arrComNum[i] = Math.floor(Math.random()*45)+1;
                j = 0; 
            }
        }
    }
    bonusComNum = Math.floor(Math.random()*45)+1;
    for(var i = 0; i < 6; i++){
        while(true){
            if(bonusComNum != arrComNum[i]){
                break;
            }
            bonusComNum = Math.floor(Math.random()*45)+1;
            j = 0;
        }
    }
}

//플레이어 번호와 컴퓨터 번호 비교
function FindSame(){
    sameNum = 0;
    bonusSame = false;
    for(var i = 0; i < 6; i++){
        for(var j = 0; j < 6; j++){
            if(arrComNum[i] == arrPlayerNum[j]){
                sameNum += 1;
            }
            if(arrPlayerNum[i] == bonusComNum){
                bonusSame = true;
            }
        }
    }
}
//번호 표시
function SetResultBall(){
    var i;
    for(i = 0; i < 6; i++){
        getResultBall[i].innerHTML = arrPlayerNum[i];
        getResultBall[i].style.backgroundColor = SetBallColor(arrPlayerNum[i]);
    }
    for(; i < 12; i++){
        getResultBall[i].innerHTML = arrComNum[i-6];
        getResultBall[i].style.backgroundColor = SetBallColor(arrComNum[i-6]);
    }
    getResultBall[i].innerHTML = bonusComNum;
    getResultBall[i].style.backgroundColor = SetBallColor(bonusComNum);
}
//등수 표시
function SetResultPrice() {
    switch (sameNum) {
        case 0:
        case 1:
        case 2:
            getResultPrice.innerHTML = "당첨이 되지 않았습니다."
            break;
        case 3:
            getResultPrice.innerHTML = "5등 당첨."
            break;
        case 4:
            getResultPrice.innerHTML = "4등 당첨."
            break;
        case 5:
            if (bonusSame == true) {
                getResultPrice.innerHTML = "2등 당첨"
            }
            else {
                getResultPrice.innerHTML = "3등 당첨"
            }
            break;
        case 6:
            getResultPrice.innerHTML = "1등 당첨."
            break;
    }
}
function SetBallColor(number){
    if(number >= 1 && number < 10){
        return "orange";
    }
    else if(number >= 10 && number < 20){
        return "blue";
    }
    else if(number >= 20 && number < 30){
        return "red";
    }
    else if(number >= 30 && number < 40){
        return "gray";
    }
    else if(number >= 40 && number <= 45){
        return "green";
    }
    else{
        return "black";
    }
}
function Resume(){
    for(var i = 0; i<6; i++){
        getMyNum[i].value = null;
    }
    getLottoScreen.style.display = "flex";
    getResultScreen.style.display = "none";
}