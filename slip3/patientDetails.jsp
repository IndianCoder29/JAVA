<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Details</title>
</head>
<body>
    <h2>Patient Details</h2>
    <table border="1">
        <tr>
            <th>PNo</th>
            <th>PName</th>
            <th>Address</th>
            <th>Age</th>
            <th>Disease</th>
        </tr>
        <%-- Sample data. Replace this with your actual patient data --%>
        <%-- You can retrieve patient details from a database or any other source --%>
        <%
            // Sample patient details
            String[][] patients = {
                {"1", "John Doe", "123 Main St, City", "35", "Fever"},
                {"2", "Jane Smith", "456 Elm St, Town", "40", "Flu"},
                {"3", "Alice Johnson", "789 Oak St, Village", "25", "Cough"}
            };
            
            // Loop through each patient and display their details in a table row
            for (String[] patient : patients) {
        %>
        <tr>
            <td><%= patient[0] %></td>
            <td><%= patient[1] %></td>
            <td><%= patient[2] %></td>
            <td><%= patient[3] %></td>
            <td><%= patient[4] %></td>
        </tr>
        <% } // End of for loop %>
    </table>
</body>
</html>