package slip30;

import java.sql.*;

public class ScrollableResultSetDemo {
    public static void main(String[] args) {
        String DATABASE_URL = "jdbc:postgresql://localhost:5432/yourDatabase";
        String USERNAME = "yourUsername";
        String PASSWORD = "yourPassword";
        try {
            // Establish a connection to the PostgreSQL database
            Connection connection = DriverManager.getConnection(DATABASE_URL,
                    USERNAME, PASSWORD);
            // Create a statement that produces a scrollable and updatable resultset
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            // Execute a query to get a result set
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Teacher");
            // Scroll through the result set
            while (resultSet.next()) {
                int TID = resultSet.getInt("TID");
                String TName = resultSet.getString("TName");
                double Salary = resultSet.getDouble("Salary");
                System.out.println("TID: " + TID + ", TName: " + TName + ", Salary:" + Salary);
            }
            // Move the cursor to the first row
            resultSet.first();
            System.out.println("\nFirst row:");
            System.out.println("TID: " + resultSet.getInt("TID") + ", TName: " + resultSet.getString("TName")
                    + ", Salary: " + resultSet.getDouble("Salary"));
            // Move the cursor to the last row
            resultSet.last();
            System.out.println("\nLast row:");
            System.out.println("TID: " + resultSet.getInt("TID") + ", TName: " +
                    resultSet.getString("TName") + ", Salary: " + resultSet.getDouble("Salary"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
