package slip13;

import java.sql.*;

public class Main1 {
    public static void main(String[] args) {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            // Connect to the PostgreSQL database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourDB", "username","password");
            // Get metadata about the database
            DatabaseMetaData metaData = connection.getMetaData();
            // Display information about the database
            System.out.println("Database Product Name: " +
                    metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " +
                    metaData.getDatabaseProductVersion());
            System.out.println("Logged User: " + metaData.getUserName());
            System.out.println("JDBC Driver: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());
            System.out.println("\n");
            // Get the tables in the database
            ResultSet resultSet = metaData.getTables(null, null, "%", new String[] { "TABLE" });
            // Display all the tables
            System.out.println("Tables in the database:");
            while (resultSet.next()) {
                System.out.println(" " + resultSet.getString("TABLE_NAME"));
            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}