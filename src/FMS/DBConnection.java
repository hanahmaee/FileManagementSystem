
package FMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/FMS?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "30Jhamespineda";
        
        return DriverManager.getConnection(url, user, password);
    }
}
