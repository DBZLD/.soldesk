var getLoginId;
var getLoginPs;
var getLoginMessage;
var stLoginId;
var stLoginPs
var nowTime;
var getDate;
var timerText;

window.onload = function(){
    getLoginId = document.getElementById("loginId");
    getLoginPs = document.getElementById("loginPs");
    getLoginMessage = document.getElementById("loginMessage");
    timerText = document.getElementById("clock");
    setInterval(Clock, 1000);
}
function Login(){
    stLoginId = getLoginId.value;
    stLoginPs = getLoginPs.value;

    if(stLoginId == "cat" && stLoginPs == "1234"){
        alert("로그인 성공");
        getLoginMessage.innerHTML = stLoginId + " 회원님 반갑습니다.";
    }
    else{
        alert("로그인 실패");
    }
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
