<%@ page import="java.sql.*" %>
    <% try
    { 
            String username=request.getParameter("username"); 
            String password=request.getParameter("password");
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe "," system","1234"); 

            PreparedStatement stmt=con.prepareStatement("select AdminPassword from AdminRegister where AdminId=?");
            stmt.setString(1,username); 
            String dbpass=null;

            ResultSet rs=stmt.executeQuery(); 
            if(rs.next()) 
            {
                    dbpass=rs.getString(1); 
            } 
            if(password.equals(dbpass)) 
            { 
                out.println("login success fully"); 
            } 
            else 
            {
                out.println("please Enter Your correct Email and Password"); 
            } 
            con.close(); 
    }catch(Exception e)
    {
        System.out.println(e);
    }       
    %>