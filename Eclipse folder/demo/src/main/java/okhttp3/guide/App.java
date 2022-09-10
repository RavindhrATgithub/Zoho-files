package okhttp3.guide;

import java.io.BufferedOutputStream;


import org.json.simple.JSONObject;    
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.Set;

import okhttp3.Handshake;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;


public class App
{
  final OkHttpClient client = new OkHttpClient();

  Response run(String url) throws IOException 
  {
	  Request request = new Request.Builder()
        .url(url)
        .build();

      try (Response response = client.newCall(request).execute()) 
    
       {
    	  File file= new File("C:\\Users\\PRABHU K\\Desktop\\nemp\\image.jpg");
    	    
    	     BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(file));
    	   
    	   
    	     InputStream ins=response.body().byteStream();
    	    
    	     int b=ins.read();
    	     while(b!=-1) {
    	    	
    	    	 out.write(b);
    	    	 b=ins.read();
    	    	 
    	    	 
    	     }
    	       
    	     out.close();
    	     System.out.println("Sucessfully downloaded and copied");
         	 return response;
     
    }
  }

  public static void main(String[] args) throws IOException 
  {
    App example = new App();
    Response response = example.run("https://cdn.pixabay.com/photo/2014/11/13/06/12/boy-529067_960_720.jpg");
 
 
    if(response.isSuccessful())
    {
     System.out.println("Connection is successfully established And the Response Code is: "+response.code());
    } 
   
    Handshake obj= response.handshake();
    TlsVersion tlsv= obj.tlsVersion();

    JSONObject JsonData=new JSONObject();    

    JsonData.put("HTTP_Version", response.protocol().toString());
    JsonData.put("TLS_Version", tlsv.name().toString());
  
   System.out.println("\nJSON Object: " + JsonData);
   System.out.println("\n    KEYS  \tVALUES\n");
   Set<String> Listobj= JsonData.keySet();
   Collection<String> values=JsonData.values();
   if(response.code()==200) 
	{

    InetAddress ip=InetAddress.getByName("www.zohocorp.com");
    JsonData.put("Resolved IP", ip.getHostAddress());
    
    long time1,time2;
   
    time1=java.time.LocalTime.now().getNano();
    Socket s=new Socket(ip.getHostAddress(),443);
    
    
    if(s.isConnected())
    {
    	time2=java.time.LocalTime.now().getNano();
    	JsonData.put("Time latency",(time2-time1)+" NanoSeconds");
    }
    
    
    }
	 for(String i:Listobj)
	 {
		System.out.println(i+"\t"+ JsonData.get(i));
	 }
  } 
}