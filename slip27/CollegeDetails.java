package slip27;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CollegeDetails {
    public static void main(String[] args) {
        String DATABASE_URL = "jdbc:postgresql://localhost:5432/yourDatabase";
        String USERNAME = "yourUsername";
        String PASSWORD = "yourPassword";
        String[] columnNames = { "CID", "CName", "Address", "Year" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL,
                    USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM College");
            while (resultSet.next()) {
                String CID = resultSet.getString("CID");
                String CName = resultSet.getString("CName");
                String address = resultSet.getString("address");
                String year = resultSet.getString("year");
                model.addRow(new Object[] { CID, CName, address, year });
            }
            JTable table = new JTable(model);
            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
