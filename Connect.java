import java.sql.*;
public class Connect {
    Connection c;
    Statement s;
    Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///tourismorganization","root","Repair10@");
            s= c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
