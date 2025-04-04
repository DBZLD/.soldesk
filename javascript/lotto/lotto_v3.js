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
var getInfoScreen;
var checkBoxCount;

var nMoney = 100000;
var nFirstCount = 0;
var nSecondCount = 0;
var nThirdCount = 0;
var nFourthCount = 0;
var nFifthCount = 0;
var nLosingCount = 0;
var nRollCount = 0;

window.onload = function () {
    getLottoScreen = document.getElementById("lottoScreen");
    getResultScreen = document.getElementById("resultScreen");
    getInfoScreen = document.getElementById("infoScreen");
    getResultBall = document.getElementsByClassName("resultBall");
    getResultPrice = document.getElementById("resultPriceScreen");
    getCheckBox = document.getElementsByName("checkBoxNumber");
    CountCheckBox();
    UpdateInfoText();
}
//체크된 체크박스 개수 카운트
function CountCheckBox(checkBox) {
    var query = 'input[name="checkBoxNumber"]:checked';
    var checkedBox = document.querySelectorAll(query);
    checkBoxCount = checkedBox.length;

    if (checkBoxCount > 6) {
        alert("번호를 7개 이상 선택할 수 없습니다.");
        checkBox.checked = false;
    }
}
//버튼 클릭 이벤트(수동)
function RollLotto() {

    if (checkBoxCount < 6) {
        alert("6개의 번호를 선택해야 합니다.");
        return;
    }
    if(nMoney < 1000){
        alert("돈이 부족합니다");
        return;
    }
    nMoney -= 1000;
    nRollCount += 1;
    SetMyNumber();
    SetComNumber();
    FindSame();
    getLottoScreen.style.display = "none";
    getResultScreen.style.display = "flex";
    SetResultBall();
    SetResultPrice();
    UpdateInfoText();
}
//버튼 클릭 이벤트(자동)
function RollAutoLotto() {
    if(nMoney < 1000){
        alert("돈이 부족합니다");
        return;
    }
    nMoney -= 1000;
    nRollCount += 1;
    SetMyAutoNumber();
    SetComNumber();
    FindSame();
    getLottoScreen.style.display = "none";
    getResultScreen.style.display = "flex";
    SetResultBall();
    SetResultPrice();
    UpdateInfoText();
}
//내 번호 설정(수동)
function SetMyNumber() {
    var selectCheckBox = document.querySelectorAll('input[name="checkBoxNumber"]:checked');
    for (var i = 0; i < selectCheckBox.length; i++) {
        arrPlayerNum[i] = selectCheckBox[i].value;
    }
}
//내 번호 설정(자동)
function SetMyAutoNumber() {
    for (var i = 0; i < 6; i++) {
        arrPlayerNum[i] = Math.floor(Math.random() * 45) + 1;
        for (var j = 0; j < i; j++) {
            while (true) {
                if (arrPlayerNum[j] != arrPlayerNum[i]) {
                    break;
                }
                arrPlayerNum[i] = Math.floor(Math.random() * 45) + 1;
                j = 0;
            }
        }
    }
}
//컴퓨터 랜덤 번호 만들기
function SetComNumber() {
    for (var i = 0; i < 6; i++) {
        arrComNum[i] = Math.floor(Math.random() * 45) + 1;
        for (var j = 0; j < i; j++) {
            while (true) {
                if (arrComNum[j] != arrComNum[i]) {
                    break;
                }
                arrComNum[i] = Math.floor(Math.random() * 45) + 1;
                j = 0;
            }
        }
    }
    bonusComNum = Math.floor(Math.random() * 45) + 1;
    for (var i = 0; i < 6; i++) {
        while (true) {
            if (bonusComNum != arrComNum[i]) {
                break;
            }
            bonusComNum = Math.floor(Math.random() * 45) + 1;
            j = 0;
        }
    }
}
//플레이어 번호와 컴퓨터 번호 비교
function FindSame() {
    sameNum = 0;
    bonusSame = false;
    for (var i = 0; i < 6; i++) {
        for (var j = 0; j < 6; j++) {
            if (arrComNum[i] == arrPlayerNum[j]) {
                sameNum += 1;
            }
            if (arrPlayerNum[i] == bonusComNum) {
                bonusSame = true;
            }
        }
    }
}
//번호 표시
function SetResultBall() {
    var i;
    arrPlayerNum.sort(function(a, b)  {
        return a - b;
      });
    arrComNum.sort(function(a, b)  {
        return a - b;
      });
    for (i = 0; i < 6; i++) {
        getResultBall[i].innerHTML = arrPlayerNum[i];
        getResultBall[i].style.backgroundColor = SetBallColor(arrPlayerNum[i]);
    }
    for (; i < 12; i++) {
        getResultBall[i].innerHTML = arrComNum[i - 6];
        getResultBall[i].style.backgroundColor = SetBallColor(arrComNum[i - 6]);
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
            nLosingCount += 1;
            break;
        case 3:
            getResultPrice.innerHTML = "5등 당첨.&nbsp;&nbsp;&nbsp;(+5000원)"
            nFifthCount += 1;
            nMoney += 5000;
            break;
        case 4:
            getResultPrice.innerHTML = "4등 당첨.&nbsp;&nbsp;&nbsp;(+50000원)"
            nFourthCount += 1;
            nMoney += 50000;
            break;
        case 5:
            if (bonusSame == true) {
                getResultPrice.innerHTML = "2등 당첨&nbsp;&nbsp;&nbsp;(+1000000원)"
                nSecondCount += 1;
                nMoney += 10000000;
            }
            else {
                getResultPrice.innerHTML = "3등 당첨&nbsp;&nbsp;&nbsp;(+100000원)"
                nThirdCount += 1;
                nMoney += 1000000;
            }
            break;
        case 6:
            getResultPrice.innerHTML = "1등 당첨.&nbsp;&nbsp;&nbsp;(+100000000원)"
            nFirstCount += 1;
            nMoney += 100000000;
            break;
    }
}
//공 색깔 정하기
function SetBallColor(number) {
    if (number >= 1 && number < 10) {
        return "orange";
    }
    else if (number >= 10 && number < 20) {
        return "blue";
    }
    else if (number >= 20 && number < 30) {
        return "red";
    }
    else if (number >= 30 && number < 40) {
        return "gray";
    }
    else if (number >= 40 && number <= 45) {
        return "green";
    }
    else {
        return "black";
    }
}
//로또 선택 화면으로 돌아가기
function Resume() {
    for (var i = 0; i < getCheckBox.length; i++) {
        getCheckBox[i].checked = false;
    }
    getLottoScreen.style.display = "flex";
    getResultScreen.style.display = "none";
}
//상단 정보 갱신
function UpdateInfoText() {
    getInfoScreen.innerHTML = "1등 횟수 : " + nFirstCount + 
    "&nbsp;&nbsp;&nbsp;&nbsp;2등 횟수 : " + nSecondCount +
    "&nbsp;&nbsp;&nbsp;&nbsp;3등 횟수 : " + nThirdCount +
    "&nbsp;&nbsp;&nbsp;&nbsp;4등 횟수 : " + nFourthCount +
    "&nbsp;&nbsp;&nbsp;&nbsp;5등 횟수 : " + nFifthCount +
    "&nbsp;&nbsp;&nbsp;&nbsp;미당첨 횟수 : " + nLosingCount +
    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;시도 횟수 : " + nRollCount +
    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;남은 돈 : " + nMoney + "원";
} 