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

    alert("아이디 : " + stLoginId +'\n' + "비밀번호 : " + stLoginPs);
}
