package TravellingAgency;

import java.sql.*;

public class DatabaseOperationCustomer {
    private Connection connection;
    private Statement statement;
    private String ConnectionUrl="jdbc:mysql://localhost:3306/traveling_agency";

    public DatabaseOperationCustomer() throws SQLException
    {
        connect();
    }

    private void connect() throws SQLException
    {
        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.connection = DriverManager.getConnection(ConnectionUrl,"root","");
            this.statement = this.connection.createStatement();
            System.out.println("Database connected....");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void addCustomer(String FirstName,String LastName,String Email, int ContactNumber)
    {
        String sql="INSERT INTO Customer(FirstName,LastName,Email,ContactNumber) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement=null;

        try{
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1,FirstName);
            preparedStatement.setString(2,LastName);
            preparedStatement.setString(3,Email);
            preparedStatement.setInt(4,ContactNumber);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted>0)
            {
                System.out.println("Record inserted Successfully..");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            try
            {
                preparedStatement.close();
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
    }

    public void updateCustomer(String FirstName,String LastName,String Email, int ContactNumber)
    {
        String sql = "UPDATE Customer SET FirstName=?, LastName=?, ContactNumber=? WHERE Email=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, FirstName);
            preparedStatement.setString(2, LastName);
            preparedStatement.setInt(3,ContactNumber);
            preparedStatement.setString(4, Email);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("No record found with Email: " + Email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            try
            {
                preparedStatement.close();
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void deleteCustomer(String Email)
    {
        String sql = "DELETE FROM Customer WHERE Email=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Email);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record Deleted Successfully");
            } else {
                System.out.println("No record found with Email: " + Email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            try
            {
                preparedStatement.close();
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
