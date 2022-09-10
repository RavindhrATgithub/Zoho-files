package pack.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class serveFile extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException  {
		
		try{
		
		PrintWriter out=res.getWriter();
		  String url= req.getParameter("url");
		  InetAddress ip=InetAddress.getByName(url);
		 
		    long time1,time2;
		   
		    time1=java.time.LocalTime.now().getNano();
		    Socket s=new Socket(ip.getHostAddress(),443);
		    
		    res.setContentType("text/html");
		    if(s.isConnected())
		    {
		    	time2=java.time.LocalTime.now().getNano();
		  
		    	out.print("<h3 style='font-size:25px;'>Time latency is :  "+String.valueOf(Math.abs((time2-time1)/1000000))+" ms (milliseconds)</h3>");
		    }
		    
		   
		  
		  
		System.out.print("hi");
		
		out.print("<form "
				+ "action='http://localhost:8080/Main1/NewFile.html' method='get'>"
				+ "<button>"
				+ "Go to Home Page"
				+ "</button>"
				+ "</form>");
		
		
		
		}
		catch(Exception e){
			PrintWriter out=res.getWriter();
			out.print("error occured");
		}

	}

}
