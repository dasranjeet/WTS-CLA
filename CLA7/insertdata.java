package cla;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/insertdata")
public class insertdata extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String sid=request.getParameter("id");
		String sname=request.getParameter("name");
		String sage=request.getParameter("age");
		String sadd=request.getParameter("address");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement insert=con.prepareStatement("insert into std values('"+sid+"','"+sname+"','"+sage+"','"+sadd+"')");
			if (insert.executeUpdate()>0) {
				response.getWriter().print("your data has been inserted");
			}else {
				response.getWriter().print("sorry, some error has occurred");
			}
	        con.close();
		} catch (Exception e) {
            response.getWriter().print(e);
		}
	}
}