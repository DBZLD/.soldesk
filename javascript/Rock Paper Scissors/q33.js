var nPlayer;
var stPlayer = "";
var nCom;
var stCom = "";
var winLose = "";

var inputPlayerText;
var resultScreenText;
var divImgPlayer;
var divImgCom;
window.onload = function(){
    inputPlayerText = document.getElementById("inputPlayer");
    resultScreenText = document.getElementById("resultScreen");
    divImgPlayer = document.getElementById("imgPlayer");
    divImgCom = document.getElementById("imgCom");
}
function PressButton(){
    while(true){
        stPlayer = inputPlayerText.value;
        if(stPlayer == "가위"||stPlayer == "바위"||stPlayer == "보"){
            break;
        }
        else{
            alert("값을 다시 입력해주세요");
        }
    }
    SetCom();
    SetPlayer();
    SetResult();
    PrintResult();
    SetImg();
}

function SetCom(){
    nCom = Math.floor(Math.random()*3);
    if(nCom == 0) { stCom = "가위"; }
    if(nCom == 1) { stCom = "바위"; }
    if(nCom == 2) { stCom = "보"; }
}
function SetPlayer(){
    if(stPlayer == "가위") { nPlayer = 0; }
    if(stPlayer == "바위") { nPlayer = 1; }
    if(stPlayer == "보") { nPlayer = 2; }
}

function SetResult(){
    if(nPlayer == nCom)
        {
            winLose = "비김";
        }
        else if(nPlayer-nCom == 1 || nPlayer-nCom == -2)
            {
                winLose = "이김";
            }
            else 
            {
                winLose = "짐";
            }
}
function SetImg(){
    switch(stPlayer){
        case "가위" :
            divImgPlayer.innerHTML = "<img src = 'scissors.png'>";
            break;
        case "바위" :
            divImgPlayer.innerHTML = "<img src = 'rock.png'>";
            break;
        case "보" :
            divImgPlayer.innerHTML = "<img src = 'paper.png'>";
            break;
            default:
                break;
        }
    switch(stCom){
        case "가위" :
            divImgCom.innerHTML = "<img src = 'scissors.png'>";
            break;
        case "바위" :
            divImgCom.innerHTML = "<img src = 'rock.png'>";
            break;
        case "보" :
            divImgCom.innerHTML = "<img src = 'paper.png'>";
            break;
            default:
                break;
        }
}
function PrintResult(){
    resultScreenText.value = ("플레이어 : " + stPlayer + "\n" + "컴퓨터 : " + stCom + "\n" + "승패 : " + winLose);
}