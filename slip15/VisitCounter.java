package slip15;

import javax.servlet.http.Cookie;
public class VisitCounter {
 public static int incrementVisitCount(Cookie[] cookies) {
 int count = 1;
 if (cookies != null) {
 for (Cookie cookie : cookies) {
 if (cookie.getName().equals("visitCount")) {
 count = Integer.parseInt(cookie.getValue()) + 1;
 }
 }
 }
 return count;
 }
}