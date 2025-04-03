var nPlayer;
var stPlayer = "";
var nCom;
var stCom = "";
var winLose = "";

var inputPlayerText;
window.onload = function()
{
    inputPlayerText = document.getElementById("inputPlayer");
}
function SetCom()
{
    nCom = Math.floor(Math.random()*3);
    if(nCom == 0) { stCom = "가위"; }
    if(nCom == 1) { stCom = "바위"; }
    if(nCom == 2) { stCom = "보"; }
}
function SetPlayer()
{
    if(stPlayer == "가위") { nPlayer = 0; }
    if(stPlayer == "바위") { nPlayer = 1; }
    if(stPlayer == "보") { nPlayer = 2; }
}

function SetResult()
{
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
function PrintResult()
{
    dw("플레이어 : " + stPlayer);
    br();
    dw("컴퓨터 : " + stCom);
    br();
    dw(winLose);
}
function PressButton()
{
    while(true)
        {
            stPlayer = inputPlayerText.value;
            if(stPlayer == ("가위" || "바위" || "보"))
            {
                SetCom();
                SetPlayer();
                SetResult();
                PrintResult();
            }
            else
            {
                alert("값을 다시 입력해주세요");
            }
            break;
        }
}