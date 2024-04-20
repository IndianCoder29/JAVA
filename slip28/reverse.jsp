<%@ page import="ReverseString" %>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
 <title>Reverse String</title>
</head>
<body>
<%
 String inputString = request.getParameter("inputString");
 String reversedString = ReverseString.reverse(inputString);
%>
<p>The reverse of <%=inputString%> is <%=reversedString%>.</p>
</body>
</html>