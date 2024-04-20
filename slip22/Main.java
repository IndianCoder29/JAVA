package slip22;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/yourDatabase", "yourUsername",
                    "yourPassword");
            while (true) {
                System.out.println("1. Insert\n2. Update\n3. Display\n4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.print("Enter ENo: ");
                    int eno = scanner.nextInt();
                    System.out.print("Enter EName: ");
                    String ename = scanner.next();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    String sql = "INSERT INTO Employee (ENo, EName, Salary) VALUES (?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, eno);
                    stmt.setString(2, ename);
                    stmt.setDouble(3, salary);
                    stmt.executeUpdate();
                    System.out.println("Record inserted successfully.");
                } else if (choice == 2) {
                    System.out.print("Enter ENo to update: ");
                    int eno = scanner.nextInt();
                    System.out.print("Enter new Salary: ");
                    double salary = scanner.nextDouble();
                    String sql = "UPDATE Employee SET Salary = ? WHERE ENo = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setDouble(1, salary);
                    stmt.setInt(2, eno);
                    stmt.executeUpdate();
                    System.out.println("Record updated successfully.");
                } else if (choice == 3) {
                    String sql = "SELECT * FROM Employee";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println("ENo: " + rs.getInt("ENo") + ", EName: "
                                + rs.getString("EName") + ", Salary: " + rs.getDouble("Salary"));
                    }
                } else if (choice == 4) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            scanner.close();
        }
    }
}