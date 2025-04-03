var stId;
var stPw;
var stPwCheck;
var stName;
var stEmail;
var stBirthYear;
var stBirthMonth;
var stBirthDay;
var stGender;
var stPhoneNumber1;
var stPhoneNumber2;
var stPhoneNumber3;

var getId;
var getPw;
var getPwCheck;
var getName;
var getEmail;
var getBirthYear;
var getBirthMonth;
var getBirthDay;
var getGender;
var getPhoneNumber1;
var getPhoneNumber2;
var getPhoneNumber3;

window.onload = function(){
    getId = document.getElementById("caId");
    getPw = document.getElementById("caPw");
    getPwCheck = document.getElementById("caPwCheck");
    getName = document.getElementById("caName");
    getEmail = document.getElementById("caEmail");
    getBirthYear = document.getElementById("caBirthYear");
    getBirthMonth = document.getElementById("caBirthMonth");
    getBirthDay = document.getElementById("caBirthDay");
    getGender = document.getElementById("caGender");
    getPhoneNumber1 = document.getElementById("caPhoneNumber1");
    getPhoneNumber2 = document.getElementById("caPhoneNumber2");
    getPhoneNumber3 = document.getElementById("caPhoneNumber3");
}

function CreateAccount(){
    stId = getId.value;
    stPw = getPw.value;
    stPwCheck = getPwCheck.value;
    stName = getName.value;
    stEmail = getEmail.value;
    stBirthYear = getBirthYear.value;
    stBirthMonth = getBirthMonth.value;
    stBirthDay = getBirthDay.value;
    stGender = getGender.value;
    stPhoneNumber1 = getPhoneNumber1.value;
    stPhoneNumber2 = getPhoneNumber2.value;
    stPhoneNumber3 = getPhoneNumber3.value;

    if(CheckId() && CheckPs() && CheckName() && CheckEmail() && CheckPhoneNumber()){
        alert("회원가입 성공");
    }
    else{
        alert("회원가입 실패");
    }
}
function CheckId(){
    if(stId.length>=6 && stId.length<=12){
        return true;
    }
    else{
        return false;
    }
}
function CheckPs(){
    if(stPw.length>=6 && stPw.length<=15 && stPwCheck.length>=6 && stPwCheck.length<=15){
        return true;
    }
    else{
        return false;
    }
}
function CheckName(){
    if(stName.length>=2){
        return true;
    }
    else{
        return false;
    }   
}
function CheckEmail(){
    if(stEmail.length>=11){
        return true;
    }
    else{
        return false;
    }
}
function CheckPhoneNumber(){
    if(stPhoneNumber1.length==3 && stPhoneNumber2.length==4 && stPhoneNumber3.length==4){
        return true;
    }
    else{
        return false;
    }    
}

