package TravellingAgency;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseCustomerTablePanel extends JPanel {
    private JTable table;

    public DatabaseCustomerTablePanel() {

        setLayout(new BorderLayout());
        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();

        // Set column names
        model.setColumnIdentifiers(new Object[]{"Customer Id", "First Name", "Last Name", "Email", "Contact Number"});

        // Retrieve data from the database
        fetchDataFromDatabase(model);

        // Create the JTable with the DefaultTableModel
        table = new JTable(model);
        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the frame
        add(scrollPane, BorderLayout.CENTER);
        // Display the frame
        setVisible(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void fetchDataFromDatabase(DefaultTableModel model) {
        // JDBC connection parameters
        String url = "jdbc:mysql://localhost:3306/traveling_agency";
        String username = "root";
        String password = "";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query to retrieve data
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer");

            // Iterate through the result set and add data to the model
            while (rs.next()) {
                int id;
                String FName;
                String LName;
                String Email;
                int ContactNumber;
                model.addRow(new Object[]{
                        id = rs.getInt("CustomerId"),
                        FName = rs.getString("FirstName"),
                        LName = rs.getString("LastName"),
                        Email = rs.getString("Email"),
                        ContactNumber = rs.getInt("ContactNumber"),
                });
            }

            // Close the resources
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}