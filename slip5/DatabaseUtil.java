package slip5;

import java.sql.*;
import java.util.*;

public class DatabaseUtil {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourDB", "username",
                    "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM questions ORDER BY RANDOM() LIMIT 10");
            while (resultSet.next()) {
                Question question = new Question();
                question.setQuestion(resultSet.getString("question"));
                question.setOptions(new String[] { resultSet.getString("option1"),
                        resultSet.getString("option2"), resultSet.getString("option3"),
                        resultSet.getString("option4") });
                question.setAnswer(resultSet.getString("answer"));
                questions.add(question);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
}