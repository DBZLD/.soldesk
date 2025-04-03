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
    getGender = document.getElementsByName("gender");
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
    for(var i = 0; i < getGender.length; i++){
        if(getGender[i].checked == true){
            stGender = getGender[i].value;
        }
    }
    stPhoneNumber1 = getPhoneNumber1.value;
    stPhoneNumber2 = getPhoneNumber2.value;
    stPhoneNumber3 = getPhoneNumber3.value;

    if(CheckId() && CheckPw() && CheckPwCheck() && CheckName() && CheckEmail() && CheckPhoneNumber()){
        alert("회원가입 성공");
        PrintInput();
    }
    else{
        alert("회원가입 실패");
    }
    console.log("CheckID : " + CheckId());
    console.log("CheckPw : " + CheckPw());
    console.log("CheckPwCheck : " + CheckPwCheck());
    console.log("CheckName : " + CheckName());
    console.log("CheckEmail : " + CheckEmail());
    console.log("CheckPhoneNumber : " + CheckPhoneNumber());
}
function CheckId(){
    if(stId.length>=6 && stId.length<=12){
        return true;
    }
    else{
        return false;
    }
}
function CheckPw(){
    if(stPw.length>=6 && stPw.length<=15 && stPwCheck.length>=6 && stPwCheck.length<=15){
        return true;
    }
    else{
        return false;
    }
}
function CheckPwCheck(){
    if(stPw == stPwCheck){
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
function PrintInput(){
    alert("Id : "+stId);
    alert("Pw : "+stPw);
    alert("PwCheck : "+stPwCheck);
    alert("Name : "+stName);
    alert("Email : "+stEmail);
    alert("Birth : "+stBirthYear + "." + stBirthMonth + "." + stBirthDay);
    alert("Gender : "+stGender);
    alert("PhoneNumber : "+stPhoneNumber1 + "-" + stPhoneNumber2 + "-" + stPhoneNumber3);
}

