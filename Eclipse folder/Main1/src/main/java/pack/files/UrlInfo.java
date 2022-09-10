package pack.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import okhttp3.Handshake;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;


public class UrlInfo extends HttpServlet
{
 
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
 {	
	 PrintWriter out=res.getWriter();
	 
	 try
	 {
	 final OkHttpClient client = new OkHttpClient();
		  Request request = new Request.Builder()
	        .url(req.getParameter("url"))
	        .build();

	 
		Response response = client.newCall(request).execute();
	 res.setContentType("text/html"); 

 

    if(response.isSuccessful())
    {
      out.print("<h2> Connection is successfully established And the Response Code is: "+response.code()+"</h>");
    } 
   
    Handshake obj= response.handshake();
    TlsVersion tlsv= obj.tlsVersion();
    

    out.print("<h3>  HTTP_Version :  "+ response.protocol().toString()+"</h3>");
    
    out.print("<p style='font-size:20px;'>HTTP is a protocol for fetching resources such as HTML documents. "
    		+ "It is the foundation of any data exchange on the Web and it is a client-server protocol, "
    		+ "which means requests are initiated by the recipient, usually the Web browser. "
    		+ "A complete document is reconstructed from the different sub-documents fetched, for instance, text, layout description, images, videos, scripts, and more.</p>");
    
    out.print("<h3>  TLS_Version :  "+ tlsv.name().toString()+"</h3>");

    out.print("<p style='font-size:20px;'>TLS is a cryptographic protocol that provides end-to-end security of data sent between applications over the Internet. "
    		+ "It is mostly familiar to users through its use in secure web browsing, and in particular the padlock icon that appears in web browsers when a secure session is established. "
    		+ "However, it can and indeed should also be used for other applications such as e-mail," 
            +  "file transers, video/audioconferencing, instant messaging and voice-over-IP, as well as Internet services such as DNS and NTP."); 
    
    InetAddress ip=InetAddress.getByName("www.zohocorp.com");
    out.print("<h3> Resolved IP : "+ ip.getHostAddress().toString()+"</h3>");
    
	
    out.print("<form "
			+ "action='http://localhost:8080/Main1/NewFile.html' method='get'>"
			+ "<button>"
			+ "Go to Home Page"
			+ "</button>"
			+ "</form>");
	
	
	 response.close();
	 }
	 catch(Exception e)
	 {
		 out.print("Invalid URL ! Try Again");
	 }
    
   
  
  } 
}