package slip27;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTimeoutServlet extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
 HttpSession session = request.getSession();
 session.setMaxInactiveInterval(15 * 60); // 15 minutes
 response.setContentType("text/html");
 response.getWriter().println("Session timeout has been set to 15 minutes.");
 }
}