package FMS;

import java.sql.*;

public class DatabaseUtils {
    // Method to fetch user credentials from the database
    public static String[] getUserCredentials(String userEmail) {
        String query = "SELECT email, password FROM users WHERE email = ?";
        
        try (Connection connection = DBConnection.getConnection(); // Using your DBConnection
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            // Set the user email as parameter for the query
            statement.setString(1, userEmail);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    return new String[]{email, password};  // Return as array [email, password]
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // If no user is found or if an error occurs
    }
}
