package TravellingAgency;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTourTablePanel extends JPanel
{
    private JTable table;

    public DatabaseTourTablePanel()
    {

        setLayout(new BorderLayout());
        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();

        // Set column names
        model.setColumnIdentifiers(new Object[]{"Tour Id", "Description", "Start Location", "Pay ID" , "Cus ID"});

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
            ResultSet rs = statement.executeQuery("SELECT * FROM Tour");

            // Iterate through the result set and add data to the model
            while (rs.next()) {
                int tourid;
                String description;
                String startLocation;
                int payid;
                int Cusid;
                model.addRow(new Object[]{
                        tourid = rs.getInt("TourId"),
                        description= rs.getString("Description"),
                        startLocation = rs.getString("StartLocation"),
                        payid = rs.getInt("Payid"),
                        Cusid = rs.getInt("Cusid"),
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
