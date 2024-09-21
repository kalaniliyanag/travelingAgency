package TravellingAgency;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabasePaymentTablePanel extends JPanel
{
    private JTable table;

    public DatabasePaymentTablePanel()
    {

        setLayout(new BorderLayout());
        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();

        // Set column names
        model.setColumnIdentifiers(new Object[]{"Payment Id", "Payment Date", "Payment Amount", "Description","Email"});

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
            ResultSet rs = statement.executeQuery("SELECT * FROM Payment");

            // Iterate through the result set and add data to the model
            while (rs.next()) {
                int payid;
                String date;
                int Amount;
                String Description;
                String Email;
                model.addRow(new Object[]{
                        payid = rs.getInt("Pay_id"),
                        date = rs.getString("PayDate"),
                        Amount = rs.getInt("PaymentAmount"),
                        Description = rs.getString("Description"),
                        Email = rs.getString("Email"),
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
