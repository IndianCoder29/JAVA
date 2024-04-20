<%@ page import="java.util.Calendar" %>
<%
 String username = request.getParameter("username");
 Calendar calendar = Calendar.getInstance();
 int hour = calendar.get(Calendar.HOUR_OF_DAY);
 String greeting;
 if (hour < 12) {
 greeting = "Good Morning";
 } else if (hour < 17) {
 greeting = "Good Afternoon";
 } else {
 greeting = "Good Evening";
 }
%>
<p><%=greeting%>, <%=username%>!</p>