package slip25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DatabaseQueryExecutor extends JFrame {
    private JTextField queryField;
    private JButton createButton, alterButton, dropButton;

    public DatabaseQueryExecutor() {
        queryField = new JTextField(40);
        createButton = new JButton("Create Table");
        alterButton = new JButton("Alter Table");
        dropButton = new JButton("Drop Table");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeQuery(queryField.getText());
            }
        });
        alterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeQuery(queryField.getText());
            }
        });
        dropButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeQuery(queryField.getText());
            }
        });
        setLayout(new FlowLayout());
        add(new JLabel("Enter your SQL query:"));
        add(queryField);
        add(createButton);
        add(alterButton);
        add(dropButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void executeQuery(String query) {
        String DATABASE_URL = "jdbc:postgresql://localhost:5432/yourDatabase";
        String USERNAME = "yourUsername";
        String PASSWORD = "yourPassword";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL,
                USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Query executed successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error executing query: " +
                    e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DatabaseQueryExecutor();
            }
        });
    }
}