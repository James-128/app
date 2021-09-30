import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    public static Connection conn = null;

    public static void loadDrive(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    public static void connect () {
        try{
        conn = DriverManager.getConnection ("jdbc:mysql://localhost/app" +
                "user=root&password=SnekByte128");
        }
        catch (SQLException e){

            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
