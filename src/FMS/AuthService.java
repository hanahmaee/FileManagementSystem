package FMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthService {

    /*public static boolean login(String email, String password) {
        boolean result = false;
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password); // Note: For security, hash this.

            ResultSet rs = stmt.executeQuery();
            result = rs.next(); // returns true if user is found
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }*/
}
