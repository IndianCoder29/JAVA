<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ include file="isPerfect.jsp" %>
<!DOCTYPE html>
<html>
<head>
 <title>Perfect Number Checker</title>
</head>
<body>
 <form method="get">
 <label for="number">Enter a number:</label>
 <input type="number" id="number" name="number" required>
 <input type="submit" value="Check">
 </form>
 <% if (request.getParameter("number") != null) { %>
 <p><%= number %> is <%= isPerfect ? "" : "not " %>a perfect number.</p>
 <% } %>
</body>
</html>