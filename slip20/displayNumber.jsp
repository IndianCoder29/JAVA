<%@ page import="NumberToWords" %>
<%
 String numStr = request.getParameter("number");
 if(numStr != null && !numStr.isEmpty()) {
 int num = Integer.parseInt(numStr);
 String words = NumberToWords.convert(num);
%>
 <p style="color:red;">The number <%=num%> in words is: <%=words%>.</p>
<%
 }
%>
<form method="get">
 <label for="number">Enter a number:</label><br>
 <input type="text" id="number" name="number"><br>
 <input type="submit" value="Submit">
</form>