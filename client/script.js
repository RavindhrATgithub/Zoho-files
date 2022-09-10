function cal(){
     
    var uuu=document.getElementById("uname").value;
    var ppp=document.getElementById("pwd").value;
    
    if(uuu!="manimala"&&uuu!="ruba")
    {
         
         alert("Username Incorrect")
    }
    else
    if(ppp!="abcde12345")
    {
        alert("Password Incorrect")
    }
    else{
        var yyy=document.getElementById("Ayear");
        var ttt=document.getElementById("Ayears")
        if(uuu=="manimala")
        {
        yyy.value=3;
        ttt.value=3;
        }
        else
        {
        yyy.value=2;
        ttt.value=2;
        }
        call()
    }
    


}


function call() {
     


    {
    var d1=document.getElementById("div1");
    var d2=document.getElementById("div2");
    d1.style.display="none";
    d2.style.display="none";
    var wastediv=document.getElementById("wastediv");
    wastediv.style.display="block";
    }

}



function call1() {
  
    var u=document.getElementById("Suname").value;
    var p=document.getElementById("Spwd").value;
    var YEAR=document.getElementsByName('year');
    let ucheck=u;
    if(u===""||ucheck.length<7)
    {
           alert("Enter the correct username ")
    }
    else if(p===""||p!=="userAT1234")
    {

        alert("Enter the correct password")
    }
    else if(!(YEAR[0].checked||YEAR[1].checked))
    {
         alert("Please select the Year")
    }
    else{
        alert("Loggedin successfully");
    
       
        var yearselector="";
        if(YEAR[0].checked)
         {yearselector="div"}
         else
        {yearselector="siv"}


// alert(yearselector)
        var div1=document.getElementById("div1");
        var div2=document.getElementById("div2"); 
        div1.style.display="none";
        div2.style.display="none";

        var mdiv=document.getElementsByClassName("maindiv");
        mdiv[0].style.display="none";
        mdiv[1].style.display="none";
      
        
        
        var sdiv=document.getElementsByClassName(yearselector);
        for(i=0;i<6;i++)
        {
        sdiv[i].style.display="block";
    
        }
     

    
         //  two.remove;    
      
        
       document.getElementById("mainform").style.display="block";
    }
  
}
var check=[0,0,0,0,0,0];
var filled=0;
function submitfun(){

   for(let i=0;i<6;i++)
   {
       if(check[i]);
       else 
       filled=1;
   }
   if(filled==1){

    alert("Please complete all the subjects")
    filled=0;
    return false;
   }

   if(filled!=1){

      var v=0,e=0,g=0,s=0,p=0;
      for(var i=1;i<7;i++)
        {
            for(var j=1;j<21;j++)
            {
               var u=document.getElementById("sub"+i+"ans"+j);
               if(u.value=="4")
               {
                   e+=1;
               }
               else
               if(u.value=="5")
               {
                   v+=1;
               }
               else
               if(u.value=="3")
               {
                   g+=1;
               }
               else
               if(u.value=="2")
               {
                   s+=1;
               }
               else
               if(u.value=="1")
               {
                   p+=1;
               }

            }
     
             for(var h=1;h<7;h++){

               var ee=document.getElementById("E"+i);
               var vv=document.getElementById("V"+i);
               var gg=document.getElementById("G"+i);
               var ss=document.getElementById("S"+i);
               var pp=document.getElementById("P"+i);

               ee.value=e;
               vv.value=v;
               gg.value=g;
               ss.value=s;
               pp.value=p;
                
             }




            v=0;  e=0;  g=0;  s=0; p=0;
        }

      var eeee=document.getElementsByName("elective");
      var sss=document.getElementById("selective");
      if(eeee[0].checked)
        sss.value="AI";
        else if(eeee[1].checked)
        sss.value="PY";  
        else{
         let kkk=document.getElementsByName("year");
        if(kkk[1].checked){    
        alert("Please select the elective")
        return false;}
        else  
        return true;
        }





      alert("Completed! Thankyou for your responses "); 
      return true;
   }


}
var counting=0;
var subject=0;
var tempdiv=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];

var flag=0;
function subcall(num){

    if(check[num-1]==1)
    {
        alert("You have already completed this!"); return
    }

    var YEAR=document.getElementsByName('year');
        var yearselector="";
        if(YEAR[0].checked)
        {
         yearselector="div";
        }
         else
         {
        yearselector="siv";
         }   

   

    var sdiv=document.getElementsByClassName(yearselector);

    if(num>0){
    
    for(let i=0;i<6;i++)
        {
         sdiv[i].style.display="none";
        } 
        
        document.getElementById("commondiv").style.display="block";
        document.getElementById("mainform").style.display="none";
        
        subject=num;    
    }
    else
    {
      flag=0;
       for(let i=0;i<20;i++)
       {
           if(!tempdiv[i]){flag=1; }
       }     
       
       if(flag!=1)
       {
         
         for(let j=1;j<21;j++)
         {
            for(let i=1;i<=5;i++)
            {
             var inopj=document.getElementById(j+""+i+"b");
             inopj.style.background="white";
             inopj.style.filter="drop-shadow(0px 0px 5px 5px black)";
             inopj.style.width="90px";
             inopj.style.height="25px";
            
            }
            tempdiv[j-1]=0;
         }

             for(let i=0;i<6;i++)
               {
                  sdiv[i].style.display="block";
              } 
         document.getElementById("commondiv").style.display="none";
         document.getElementById("mainform").style.display="block";
         var y=sdiv[subject-1];
         y.style.background=" radial-gradient(rgb(241, 246, 247), rgb(253 223 9))";
         if(counting<=5){
         alert((++counting)+" Subjects completed");
           
         

        }
         
         if(counting==6){

          document.getElementById("Username").value=document.getElementById("Suname").value;
          if(yearselector=="div")
          {
          document.getElementById("Year").value=2;
          } 
          else
          {
            document.getElementById("Year").value=3;
          }

         } 


         flag=0;  
         check[subject-1]=1;

        }
        else {

            alert("Please answer for all the questions!");
        }
    }
    
}



function fillanswer(quesno,givenans,obj){

 var input= document.getElementById("sub"+subject+"ans"+quesno);
 input.value=givenans;
  
 tempdiv[parseInt(quesno)-1]=1;
  for(let i=1;i<=5;i++)
   {
    var inopj=document.getElementById(quesno+i+"b");
    inopj.style.background="white";
    inopj.style.filter="drop-shadow(0px 0px 5px 5px black)";
    inopj.style.width="90px";
    inopj.style.height="25px"
   
   }
    obj.style.background="rgb(255 201 5)";
    obj.style.filter="drop-shadow(5px 5px 5px 15px black)";
    obj.style.width="90px";
    obj.style.height="25px"


}
