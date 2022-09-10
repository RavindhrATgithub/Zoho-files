var p=1;
var cl=599;
var ans=0;
function call(obj,l)
{
  if(p<=11)
  {
 
     
     if(l==1)
     {
       ans++;
       //obj.style.text="green";
     }
  

  var pre=document.getElementById(""+p);
  var next=document.getElementById(""+(++p));
  
pre.style.display="none";
next.style.display="block";


  }

 
}
function answer(){

    pp=document.getElementById("answ");
    pp.innerHTML=""+ans+"/10";
    
}

function clock(){

  setInterval(func,1000)
 
  
}
function func(){
  
  var clk=document.getElementById("clk");
 
 // var ms=cl/60+"";
 // var m=cl%60+"";
 // clk.innerHTML=ms[0]+"."+m[0]+""+" minutes remaining";
 var ms=""+cl;
 //clk.innerHTML=ms[0]+""+ms[2]+""+ms[3]+" Seconds Remaining";
 clk.innerHTML=""+cl+ " Seconds Remaining";  
 cl--;
  if(ms[0]=='0')
  {
    var body=document.getElementById("body");
    body.style.display="none";
  }
  


}

