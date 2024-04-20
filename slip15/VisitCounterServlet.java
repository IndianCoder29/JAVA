package slip15;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class VisitCounterServlet extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 int count = VisitCounter.incrementVisitCount(request.getCookies());
 Cookie cookie = new Cookie("visitCount", String.valueOf(count));
 response.addCookie(cookie);
 if (count == 1) {
 out.println("<h1>Welcome to the page for the first time!</h1>");
 } else {
 out.println("<h1>Welcome back! You have visited this page " + count + "
times.</h1>");
 }
 }
}