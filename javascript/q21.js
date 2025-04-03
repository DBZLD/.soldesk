for(var i = 1; i <= 10; i++){
    for(var j = 10; j > 0; j--)
    {
        if(j<=i) { document.write("☆"); }
        else { document.write("__"); }
    }
    document.write("<br>");
}