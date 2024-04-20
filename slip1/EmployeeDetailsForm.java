import java.sql.*;
import java.util.*;

public class EmployeeDetailsForm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accepting employee details from the user
        System.out.println("Enter Employee Number:");
        int eno = sc.nextInt();
        sc.nextLine(); // Consume newline character

        System.out.println("Enter Employee Name:");
        String ename = sc.nextLine();

        System.out.println("Enter Designation:");
        String designation = sc.nextLine();

        System.out.println("Enter Salary:");
        double salary = sc.nextDouble();

        try {
            // Establishing the database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");

            // Creating a PreparedStatement to insert data into the database
            PreparedStatement statement = connection.prepareStatement("INSERT INTO employee (eno, ename, designation, salary) VALUES (?, ?, ?, ?)");
            statement.setInt(1, eno);
            statement.setString(2, ename);
            statement.setString(3, designation);
            statement.setDouble(4, salary);

            // Executing the PreparedStatement
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Employee details inserted successfully.");
            } else {
                System.out.println("Failed to insert employee details.");
            }

            // Closing the connection
            sc.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
