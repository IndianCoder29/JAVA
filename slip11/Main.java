package slip11;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            // Connect to the PostgreSQL database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourDB", "username",
                    "password");
            // Get metadata about the DONAR table
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DONAR");
            ResultSetMetaData metaData = resultSet.getMetaData();
            // Display information about all columns
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println(" Name: " + metaData.getColumnName(i));
                System.out.println(" Type: " + metaData.getColumnTypeName(i));
                System.out.println(" Size: " + metaData.getColumnDisplaySize(i));
                System.out.println(" Nullable: " + metaData.isNullable(i));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}