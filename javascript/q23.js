var rand = Math.floor(Math.random()*10)+1;

for(var i = 1; i <= 10; i++)
{
    if(i == rand) { break; }
    else { document.write(i); }
}