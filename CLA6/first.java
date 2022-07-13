package CLA6;
import java.sql.*;
public class first {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "system";
            String password = "1234";
            Connection con = DriverManager.getConnection(url, username, password);
            String a = "select * from emp";
            Statement stm = con.createStatement();
            stm.executeQuery(a);
            ResultSet rs = stm.executeQuery(a);
            System.out.println("Data retrived:-");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString("ename"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}