<%
 String name = request.getParameter("name");
 int age = Integer.parseInt(request.getParameter("age"));
 String message;
 if (age >= 18) {
 message = "You are eligible to vote.";
 } else {
 message = "You are not eligible to vote.";
 }
%>
<p><%=name%>, <%=message%></p>
