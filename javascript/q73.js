var getLoginId;
var getLoginPs;
var stLoginId;
var stLoginPs

window.onload = function(){
    getLoginId = document.getElementById("getId");
    getLoginPs = document.getElementById("getPs");
}
function Login(){
    stLoginId = getLoginId.value;
    stLoginPs = getLoginPs.value;

    if(stLoginId == "cat" && stLoginPs == "1234"){
        alert("로그인 성공");
    }
    else{
        alert("로그인 실패");
    }
}
