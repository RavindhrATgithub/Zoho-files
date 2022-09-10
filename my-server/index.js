const express= require('express');
const app= express()
const cors =require("cors");

app.use(cors());
app.get("/test",(req,res)=>{


   
    console.log("server called");
    
    res.contentType("json");
    
    const Response={"welcome": " ravindhr"};
    res.send(Response);
    
})

app.listen(100,()=>{

    console.log("server started");
});