<%
 String username = request.getParameter("username");
 String password = request.getParameter("password");
 if (username != null && password != null && username.equals(password)) {
 response.sendRedirect("success.html");
 } else {
 response.sendRedirect("error.html");
 }
%>