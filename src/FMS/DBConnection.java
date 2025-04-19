
package FMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/yourlink";
        String user = "yourusername";
        String password = "yourpassword";
        
        return DriverManager.getConnection(url, user, password);
    }
}
