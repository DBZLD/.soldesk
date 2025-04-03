window.onload = function()
{
    var a = "";

    var t = document.getElementById("a");

    while(true)
        {
            a = prompt("값을 입력하세요 : ");
            if(a == 100) { 
                    break; 
                }
            else { 
                t.innerHTML = "마지막 값:"+a+"<br>";
             }
        }
}

