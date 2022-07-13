import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/retrivedata")
public class retrivedata extends HttpServlet{
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
	String id=request.getParameter("id");
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement select=con.prepareStatement("select * from std where sid='"+id+"'");
		ResultSet rSet=select.executeQuery();
        while (rSet.next()) {
			response.getWriter().print("your id:  "+rSet.getString(1)+"\n"+"your name:  "+rSet.getString(2)+"\n"+"your age:  "+rSet.getString(3)+"\n"+"your address:  "+rSet.getString(4));
		}
        con.close();
	} catch (Exception e) {
		response.getWriter().print(e);
	}
}
}