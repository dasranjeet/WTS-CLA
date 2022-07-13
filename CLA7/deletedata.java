package cla;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deletedata")
public class deletedata extends HttpServlet{
     public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement delete=con.prepareStatement("delete from std where sname='"+name+"' and sid='"+id+"'");
			if (delete.executeUpdate()>0) {
				response.getWriter().print("your data has been deleted");
			} else {
				response.getWriter().print("sorry, some error has occurred");
			}
	        con.close();
		} catch (Exception e) {
			response.getWriter().print(e);
		}
		}
}