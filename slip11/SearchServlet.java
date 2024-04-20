package slip11;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String customerNumber = request.getParameter("customerNumber");
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            // Connect to the PostgreSQL database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourDB", "username",
                    "password");
            // Search for the customer number in the customer table
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM customer WHERE customerNumber = ?");
            preparedStatement.setString(1, customerNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Display the customer details
                out.println("<h1>Customer Details:</h1>");
                out.println("Customer Number: " +
                        resultSet.getString("customerNumber") + "<br/>");
                out.println("Customer Name: " + resultSet.getString("customerName")
                        + "<br/>");
                // Add more fields as necessary
            } else {
                // Display an error message
                out.println("<h1>No customer found with the provided number.</h1>");
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}