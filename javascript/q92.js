var nowTimer;
var nowTime;
var getTime;
var clockText;

nowTimer = 10;
window.onload = function(){
    timerText = document.getElementById("timer");
    clockText = document.getElementById("clock");
    setInterval(Clock, 1000);
}
function Clock(){
    getTime = new Date();
    clockText.innerHTML = getTime;
    
    if(nowTimer <= 0){
        timerText.innerHTML = ("불 꺼!");
    }
    else{
        timerText.innerHTML = nowTimer;
        nowTimer--;
    }
}