package slip18;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class StudentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String seatNo = request.getParameter("seatNo");
        String studName = request.getParameter("studName");
        String className = request.getParameter("class");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));
        double percentage = (double) totalMarks / 500 * 100;
        String grade;
        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        out.println("<h1>Student Details</h1>");
        out.println("<p>Seat Number: " + seatNo + "</p>");
        out.println("<p>Student Name: " + studName + "</p>");
        out.println("<p>Class: " + className + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
    }
}