var nowTime;
var getDate;

window.onload = function(){
    timerText = document.getElementById("clock");
    setInterval(Clock, 1000);
}
function Clock(){
    getDate = new Date();
    nowTime = getDate.getFullYear() + "년  " +
    getDate.getMonth()+1 + "월  " +
    getDate.getHours() + "시  " +
    getDate.getMinutes() + "분  " +
    getDate.getSeconds() + "초  " +
    getDate.getMilliseconds() + "밀리초";
    timerText.innerHTML = nowTime;
}