import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
    
public class Display extends HttpServlet  
{    
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");  
         out.println("<html><body>");  
         try 
         {  
            String dbDriver = "com.mysql.cj.jdbc.Driver"; 
			String dbURL = "jdbc:mysql://localhost:3306/migration"; 
			// Database name to access 
			String dbName = "migration"; 
			String dbUsername = "root"; 
			String dbPassword = "Mysql@root2021"; 
			
			Class.forName(dbDriver); 
			Connection con = DriverManager.getConnection(dbURL,dbUsername,dbPassword); 
			System.out.println("Creating statement..");
			Statement stmt = con.createStatement();
			String sql;
			sql = "Select * from record";
			ResultSet rs = stmt.executeQuery(sql);   
            out.println("<center><table border=1 width=50% height=50%>");  
            out.println("<tr><th>Name</th><th>Mobile</th><th>Native</th><th>Current Location</th><th>Working in</th><th>Aadhar</th><tr>");  
            while (rs.next()) 
            {  
                String n = rs.getString("name");  
                String m = rs.getString("mobile"); 
				String na = rs.getString("native");  
                String c = rs.getString("current");
				String w = rs.getString("work");  
                String a = rs.getString("aadhar");
                out.println("<tr><td>" + n + "</td><td>" + m + "</td><td>" + na + "</td><td>" + c + "</td><td>" + w + "</td><td>" + a + "</td><td>");   
            }  
            out.println("</table></center>");  
            out.println("</html></body>");  
            con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 }  