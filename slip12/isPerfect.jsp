<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%
 int number = Integer.parseInt(request.getParameter("number"));
 int sum = 0;
 for (int i = 1; i < number; i++) {
 if (number % i == 0) {
 sum += i;
 }
 }
 boolean isPerfect = sum == number;
%>
