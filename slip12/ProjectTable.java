package slip12;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;
import java.sql.*;

public class ProjectTable {
 public static void main(String[] args) {
 SwingUtilities.invokeLater(() -> {
 try {
 // Load the PostgreSQL JDBC driver
 Class.forName("org.postgresql.Driver");
 // Connect to the PostgreSQL database
 Connection connection =
DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourDB", "username",
"password");
 // Create a PROJECT table
 Statement statement = connection.createStatement();
 statement.executeUpdate("CREATE TABLE PROJECT(project_id INT PRIMARY KEY, Project_name VARCHAR(100), Project_description VARCHAR(255),Project_Status VARCHAR(50))");
 // Insert values into the table
 statement.executeUpdate("INSERT INTO PROJECT VALUES(1, 'Project 1','Description 1', 'Status 1')");
 statement.executeUpdate("INSERT INTO PROJECT VALUES(2, 'Project 2','Description 2', 'Status 2')");
 statement.executeUpdate("INSERT INTO PROJECT VALUES(3, 'Project 3','Description 3', 'Status 3')");
 statement.executeUpdate("INSERT INTO PROJECT VALUES(4, 'Project 4','Description 4', 'Status 4')");
 statement.executeUpdate("INSERT INTO PROJECT VALUES(5, 'Project 5','Description 5', 'Status 5')");
 // Get all the records from the PROJECT table
 ResultSet resultSet = statement.executeQuery("SELECT * FROM PROJECT");
 // Create a JFrame with a JTable to display the records
 JFrame frame = new JFrame("Project Table");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setLayout(new BorderLayout());
 JTable table = new JTable(new ResultSetTableModel(resultSet));
 JScrollPane scrollPane = new JScrollPane(table);
 frame.add(scrollPane, BorderLayout.CENTER);
 frame.pack();
 frame.setVisible(true);
 resultSet.close();
 statement.close();
 connection.close();
 } catch (Exception e) {
 e.printStackTrace();
 }
 });
 }
}

class ResultSetTableModel extends AbstractTableModel {
    private ResultSet resultSet;
    private ResultSetMetaData metaData;

    public ResultSetTableModel(ResultSet resultSet) throws SQLException {
        this.resultSet = resultSet;
        this.metaData = resultSet.getMetaData();
    }

    @Override
    public int getColumnCount() {
        try {
            return metaData.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getRowCount() {
        try {
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            resultSet.absolute(rowIndex + 1);
            return resultSet.getObject(columnIndex + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
}