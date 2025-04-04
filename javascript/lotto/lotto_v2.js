var arrComNum = Array(6);
var bonusComNum;
var arrPlayerNum = Array(6);
var bonusSame;
var sameNum = 0;

var getLottoScreen;
var getResultScreen;
var getResultBall;
var getResultPrice;
var getCheckBox;
var checkBoxCount;

window.onload = function(){
    getLottoScreen = document.getElementById("lottoScreen");
    getResultScreen = document.getElementById("resultScreen");
    getResultBall = document.getElementsByClassName("resultBall");
    getResultPrice = document.getElementById("resultPriceScreen");
    getCheckBox = document.getElementsByName("checkBoxNumber")
}
//체크된 체크박스 개수 카운트
function CountCheckBox(checkBox){
    var query = 'input[name="checkBoxNumber"]:checked';
    var checkedBox = document.querySelectorAll(query);
    checkBoxCount = checkedBox.length;
    
    if(checkBoxCount > 6){
        alert("6개를 초과해서 선택할 수 없습니다.");
        checkBox.checked = false;
    }
}
//버튼 클릭 이벤트
function RollLotto(){

    if(checkBoxCount < 6){
        alert("6개를 선택해야 합니다.");
        return;
    }
    SetMyNumber();
    SetComNumber();
    FindSame();
    getLottoScreen.style.display = "none";
    getResultScreen.style.display = "flex";
    SetResultBall();
    SetResultPrice();
}
function SetMyNumber(){
    var selectCheckBox = document.querySelectorAll('input[name="checkBoxNumber"]:checked');
    for(var i = 0; i < selectCheckBox.length; i++){
        arrPlayerNum[i] = selectCheckBox[i].value;
    }
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
//공 색깔 정하기
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
//로또 선택 화면으로 돌아가기
function Resume(){
    for(var i = 0; i < getCheckBox.length; i++){
        getCheckBox[i].checked = false;
    }
    getLottoScreen.style.display = "flex";
    getResultScreen.style.display = "none";
}