<html>
<body>

<h2>Hello World!</h2>
<form action="/Main1/latency">

<input type="text" name="url" autocomplete="off" required>

<%@page import="java.sql.*" 
 import="java.util.*"
 import ="java.io.BufferedInputStream"
import ="java.io.FileInputStream"
import ="java.io.IOException"
import ="java.io.InputStream"
import ="java.io.PrintWriter"
import ="java.awt.Graphics2D"
import ="java.awt.Image"
import ="java.awt.image.BufferedImage"
import ="java.io.File"
import ="java.io.IOException"
import ="javax.imageio.ImageIO"


%> 
<% int a=10; int b=20;


try {
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
} catch (SQLException e1) {
	
	e1.printStackTrace();
}
String DB_URL = "jdbc:mysql://localhost/student";
String USER = "root";
String PASS = "rootpassword";

   try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
       Statement stmt = conn.createStatement();
   ) {
	   
	   stmt.execute("use waste;");
	//  stmt.execute("insert into employee values ('das-santosh',101 );");
	//  ResultSet rs= stmt.executeQuery("select * from employee");
      
	  InputStream in=new FileInputStream("C:\\Users\\PRABHU K\\Desktop\\nemp\\TEST_file.txt");
	  PreparedStatement ps= conn.prepareStatement("insert into gallery values(?);");
	  ps.setBlob(1, in);
	  
  //    ps.execute(); 
	  int i=0;
	  
	 ResultSet rs= stmt.executeQuery("select * from gallery");
	
	 System.out.println("Connected to file database..."); 
	 while(rs.next())
	 {
	 Blob ins=rs.getBlob("image");
	   
	 BufferedInputStream bs=new BufferedInputStream(ins.getBinaryStream());
	 
	 out.print("<br>File "+(i++)+" : ");
	 
	 int  r=bs.read();
	 while(r!=-1)
	 {
		 out.print(""+(char)r);
		 r=bs.read();
	 }
           

	 
	 }


   } catch (SQLException e) {
       e.printStackTrace();
   }
 


 String d="hello";
 out.print("<input type='text' placeholder='"+d+"'><br>");
 while(a!=15)
 {
	 a++;
	 out.print(" <p>"+a+"</p>");
 }
 out.print("<input type='text' name='file'><br>");

 
 
 
 
 
 

%>

<% out.print("<h2>welcome</h2>"+a); %>

<button>Click</button>
</form>

</body>
</html>
