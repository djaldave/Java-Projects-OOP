import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectionToDatabase {
    static Connection conn = null;
    
    public static Connection connectToDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db_inv","root","");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
