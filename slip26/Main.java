package slip26;

import java.sql.*;

public class Main {
 public static void main(String[] args) {
 if (args.length == 0) {
 System.out.println("Please provide an employee ID as a command-line argument.");
 return;
 }
 int employeeId = Integer.parseInt(args[0]);
 try {
 // Establish a connection to the PostgreSQL database
 Connection conn =
DriverManager.getConnection("jdbc:postgresql://localhost/yourDatabase","yourUsername", "yourPassword");
 // Prepare an SQL statement to delete the employee record
 String sql = "DELETE FROM Employee WHERE ENo = ?";
 PreparedStatement stmt = conn.prepareStatement(sql);
 // Set the employee ID in the prepared statement
 stmt.setInt(1, employeeId);
 // Execute the prepared statement
 int rowsAffected = stmt.executeUpdate();
 // Print a success message if a row was deleted, otherwise print an error message
 if (rowsAffected > 0) {
 System.out.println("Employee " + employeeId + " was deleted successfully.");
 } else {
 System.out.println("No employee found with ID " + employeeId + ".");
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
}