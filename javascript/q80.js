var getLoginId;
var getLoginPs;
var getLoginMessage;
var stLoginId;
var stLoginPs

window.onload = function(){
    getLoginId = document.getElementById("loginId");
    getLoginPs = document.getElementById("loginPs");
    getLoginMessage = document.getElementById("loginMessage");
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
