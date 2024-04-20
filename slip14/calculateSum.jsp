package slip14;

<%@ page import="NumberUtils" %>
<%
 String numStr = request.getParameter("number");
 if(numStr != null && !numStr.isEmpty()) {
 int num = Integer.parseInt(numStr);
 int sum = NumberUtils.sumOfFirstAndLastDigit(num);
%>
 <p style="color:red; font-size:18px;">The sum of the first and last digit
of <%=num%> is <%=sum%>.</p>
<%
 }
%>
<form method="get">
 <label for="number">Enter a number:</label><br>
 <input type="text" id="number" name="number"><br>
 <input type="submit" value="Submit">
</form>