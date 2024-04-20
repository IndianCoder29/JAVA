import java.io.*;
import javax.Servlet.*;
import javax.Servlet.http.*;
import java.util.Enumeration;

public class RequestInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Request Information</title></head>");
        out.println("<body>");

        // Client Information
        out.println("<h2>Client Information:</h2>");
        out.println("<ul>");
        out.println("<li>IP Address: " + request.getRemoteAddr() + "</li>");
        out.println("<li>Browser Type: " + request.getHeader("User-Agent") + "</li>");
        out.println("</ul>");

        // Server Information
        out.println("<h2>Server Information:</h2>");
        out.println("<ul>");
        out.println("<li>Server Name: " + request.getServerName() + "</li>");
        out.println("<li>Server Port: " + request.getServerPort() + "</li>");
        out.println("<li>Server OS: " + System.getProperty("os.name") + "</li>");
        out.println("</ul>");

        // Servlet Information
        out.println("<h2>Servlet Information:</h2>");
        out.println("<ul>");
        ServletConfig config = getServletConfig();
        Enumeration<String> servletNames = config.getServletContext().getServletNames();
        while (servletNames.hasMoreElements()) {
            String servletName = servletNames.nextElement();
            out.println("<li>" + servletName + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
    }
}
