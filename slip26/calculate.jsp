<%@ page import="Calculate" %> <%@ page import="java.io.*,java.util.*" %>
<html>
  <head>
    <title>Sum of First and Last Digit</title>
  </head>
  <body>
    <% int number = Integer.parseInt(request.getParameter("number")); int sum =
    Calculate.calculateSum(number); %>
    <p style="color: red; font-size: 18px">
      The sum of the first and last digit of <%=number%> is <%=sum%>.
    </p>
  </body>
</html>
