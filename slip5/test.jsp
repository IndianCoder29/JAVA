<%@ page import="java.util.*" %> <%@ page import="Question" %> <%@ page
import="DatabaseUtil" %> <% List<Question> questions = DatabaseUtil.getQuestions();
  session.setAttribute("questions",questions); %>
  <!DOCTYPE html>
  <html>
    <head>
      <title>Online Test</title>
      <script>
         var currentQuestion = 0;
         var score = 0;
         function nextQuestion() {
         var questions = <%= new com.google.gson.Gson().toJson(questions) %>;
         var selectedOption =
        document.querySelector('input[name="option"]:checked');
         if (!selectedOption) {
         alert('Please select your answer!');
         return;
         }
         var answer = selectedOption.value;
         if (questions[currentQuestion].answer == answer) {
         score += 10;
         }
         selectedOption.checked = false;
         currentQuestion++;
         if (currentQuestion == questions.length) {
         document.getElementById('test').style.display = 'none';
         document.getElementById('result').style.display = '';
         document.getElementById('score').textContent = score;
         return;
         }
         loadQuestion(currentQuestion);
         }
         function loadQuestion(questionIndex) {
         var q = questions[questionIndex];
         document.getElementById('question').textContent = (questionIndex + 1) +
        '. ' + q.question;
         var options = document.getElementsByName('option');
         for (var i = 0; i < options.length; i++) {
         options[i].value = q.options[i];
         options[i].nextSibling.textContent = q.options[i];
         }
         }
         window.onload = function() {
         loadQuestion(currentQuestion);
         }
      </script>
    </head>
    <body>
      <div id="test">
        <h1 id="question"></h1>
        <label
          ><input type="radio" name="option" value="" /> <span></span></label
        ><br />
        <label
          ><input type="radio" name="option" value="" /> <span></span></label
        ><br />
        <label
          ><input type="radio" name="option" value="" /> <span></span></label
        ><br />
        <label
          ><input type="radio" name="option" value="" /> <span></span></label
        ><br />
        <button onclick="nextQuestion()">Next</button>
      </div>
      <div id="result" style="display: none">
        <h1>Your score is <span id="score"></span>.</h1>
      </div>
    </body>
  </html>