<%@ page import="PrimeChecker" %> <% String numberParam =
request.getParameter("number"); int number = Integer.parseInt(numberParam);
boolean isPrime = PrimeChecker.isPrime(number); %>
<!DOCTYPE html>
<html>
  <head>
    <title>Prime Checker</title>
  </head>
  <body>
    <form method="get">
      <label for="number">Enter a number:</label>
      <input type="number" id="number" name="number" required />
      <input type="submit" value="Check" />
    </form>
    <% if (numberParam != null) { %>
    <p style="color: red">
      <%= number %> is <%= isPrime ? "a prime" : "not a prime" %> number.
    </p>
    <% } %>
  </body>
</html>
