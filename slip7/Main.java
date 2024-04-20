package slip7;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            // Connect to the PostgreSQL database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourDB", "username",
                    "password");
            // Create a Product(Pid, Pname, Price) table
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "CREATE TABLE Product(Pid INT PRIMARY KEY,Pname VARCHAR(100), Price DECIMAL(10, 2))");
            // Insert at least five records into the table
            statement.executeUpdate("INSERT INTO Product VALUES(1, 'Product 1', 10.99)");
            statement.executeUpdate("INSERT INTO Product VALUES(2, 'Product 2', 20.99)");
            statement.executeUpdate("INSERT INTO Product VALUES(3, 'Product 3', 30.99)");
            statement.executeUpdate("INSERT INTO Product VALUES(4, 'Product 4', 40.99)");
            statement.executeUpdate("INSERT INTO Product VALUES(5, 'Product 5', 50.99)");
            // Display all the records from the table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Product");
            while (resultSet.next()) {
                System.out.println("Pid: " + resultSet.getInt("Pid") + ", Pname: "
                        + resultSet.getString("Pname") + ", Price: " + resultSet.getBigDecimal("Price"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}