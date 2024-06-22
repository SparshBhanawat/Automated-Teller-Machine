package atm;
import java.sql.*;

//1. register the driver
//2. create connection
//3. create statement
//4. execute query
//5. close connection
 

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///atm","root","sparsh");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
