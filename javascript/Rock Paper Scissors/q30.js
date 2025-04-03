var nPlayer;
var stPlayer = "";
var nCom;
var stCom = "";

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

function PrintResult()
{
    if(nPlayer == nCom)
        {
            document.write("비김");
        }
        else if(nPlayer-nCom == 1 || nPlayer-nCom == -2)
            {
                document.write("이김");
            }
            else 
            {
                document.write("짐");
            }
}
        stPlayer = prompt("가위, 바위, 보 : ");
        if(stPlayer == ("가위" || "바위" || "보"))
        {
            SetCom();
            SetPlayer();
            SetPlayer();
            PrintResult();
        }
        else
        {
            alert("값을 다시 입력해주세요");
        }