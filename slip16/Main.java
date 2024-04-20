package slip16;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/yourDatabase";
        String user = "yourUsername";
        String password = "yourPassword";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Insert records
            String insertSQL = "INSERT INTO Teacher(TNo, TName, Subject) VALUES (?,?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
            insertStmt.setInt(1, 1);
            insertStmt.setString(2, "John");
            insertStmt.setString(3, "Math");
            insertStmt.executeUpdate();
            // Repeat the above three lines for more records...
            // Query for teachers who are teaching "JAVA"
            String querySQL = "SELECT * FROM Teacher WHERE Subject = ?";
            PreparedStatement queryStmt = conn.prepareStatement(querySQL);
            queryStmt.setString(1, "JAVA");
            ResultSet rs = queryStmt.executeQuery();
            // Print the result
            while (rs.next()) {
                System.out.println("TNo: " + rs.getInt("TNo"));
                System.out.println("TName: " + rs.getString("TName"));
                System.out.println("Subject: " + rs.getString("Subject"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}