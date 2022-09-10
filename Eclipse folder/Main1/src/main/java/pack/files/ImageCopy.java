package pack.files;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ImageCopy extends HttpServlet {
	
	/**
	 * 
	 */
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
	
			    	  File file= new File("image"+String.valueOf(java.time.LocalTime.now().getSecond())+".jpg");
			    	    
			    	     BufferedOutputStream brOut=new BufferedOutputStream(new FileOutputStream(file));
			    	   
			    	   
			    	     InputStream ins=response.body().byteStream();
			    	    
			    	     int b=ins.read();
			    	     while(b!=-1) {
			    	    	
			    	    	 brOut.write(b);
			    	    	 b=ins.read();
			    	    	 
			    	    	 
			    	     }
			    	       
			    	     res.setContentType("text/html");
			    	     out.print("<h2> Sucessfully downloaded from the given URL </h2>");
			             out.print(" <h3> The Location of the file is :</h3><br>"+file.getAbsolutePath().toString());
			             brOut.close();  
			          System.out.print("image downloaded successfully");
			          
			          out.print("<br><form "
			  				+ "action='http://localhost:8080/Main1/NewFile.html' method='get'>"
			  				+ "<button>"
			  				+ "Go to Home Page"
			  				+ "</button>"
			  				+ "</form>");
			  		
			  			          
		response.close();	
		}
		catch(Exception e)
		{
			out.print("Invalid URL !! Please Try Again !!");
			System.out.print("error occurred:"+e);
		}
		
		
	}

}
