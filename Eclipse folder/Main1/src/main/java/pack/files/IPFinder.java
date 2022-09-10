package pack.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import okhttp3.Response;

public class IPFinder extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
	     PrintWriter out=res.getWriter();
		 try
		 {
			 
			
	     res.setContentType("text/html");
		 InetAddress ip=InetAddress.getByName(req.getParameter("url"));
         out.print("<h3> The IP Address for the given domain name is: "+ ip.getHostAddress().toString()+"</h3>");
		 
         
         out.print("<form "
 				+ "action='http://localhost:8080/Main1/NewFile.html' method='get'>"
 				+ "<button>"
 				+ "Go to Home Page"
 				+ "</button>"
 				+ "</form>");
 		
 		
         
		 }
		 catch(Exception e)
		 {
		   out.print("Invalid Domain name !! Please Try again !!");	 
		 }
		 
		 }

}
