package librarymanagementsystem;
import java.sql.*;

public class Connection_Class {
    Connection c;
    Statement s;
    
    Connection_Class() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///library", "root","");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Connection_Class();
    }
}
