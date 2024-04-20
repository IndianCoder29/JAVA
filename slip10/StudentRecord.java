package slip10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRecord {
    private JTextField txtRNo, txtSName, txtPer;
    private JButton btnLoad;

    public static void main(String[] args) {
        new StudentRecord().createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Student Record");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        txtRNo = new JTextField(10);
        txtSName = new JTextField(10);
        txtPer = new JTextField(10);
        btnLoad = new JButton("Load");
        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadRecord();
            }
        });
        frame.add(new JLabel("RNo:"));
        frame.add(txtRNo);
        frame.add(new JLabel("SName:"));
        frame.add(txtSName);
        frame.add(new JLabel("Per:"));
        frame.add(txtPer);
        frame.add(btnLoad);
        frame.pack();
        frame.setVisible(true);
    }

    private void loadRecord() {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            // Connect to the PostgreSQL database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourDB", "username",
                    "password");
            // Get the first record from the student table
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student LIMIT 1");
            if (resultSet.next()) {
                txtRNo.setText(resultSet.getString("RNo"));
                txtSName.setText(resultSet.getString("SName"));
                txtPer.setText(resultSet.getString("Per"));
            } else {
                JOptionPane.showMessageDialog(null, "No records found.");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
