var nowTime;

window.onload = function(){
    timerText = document.getElementById("timer");
    setInterval(Clock, 1000);
}
nowTime = 10;
function Clock(){
    if(nowTime <= 0){
        timerText.innerHTML = ("불 꺼!");
    }
    else{
        timerText.innerHTML = nowTime;
        nowTime--;
    }
}