package TravellingAgency;

import jdk.jfr.Description;

import java.sql.*;

public class DatabaseOperationPayment
{
    private Connection connection;
    private Statement statement;
    private String ConnectionUrl="jdbc:mysql://localhost:3306/traveling_agency";

    public DatabaseOperationPayment() throws SQLException
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
    public void addPayment(String PayDate, int PaymentAmount , String Description, String Email)
    {
        String sql="INSERT INTO Payment(PayDate,PaymentAmount,Description,Email) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement=null;

        try{
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1,PayDate);
            preparedStatement.setInt(2,PaymentAmount);
            preparedStatement.setString(3, Description);
            preparedStatement.setString(4, Email);
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
        finally
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

    public void updatePayment(String PayDate, int PaymentAmount , String Description , String Email)
    {
        String sql = "UPDATE Payment SET PayDate=?, PaymentAmount=?, Description=? WHERE Email=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, PayDate);
            preparedStatement.setInt(2, PaymentAmount);
            preparedStatement.setString(3,Description);
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

    public void deletePayment(String Email)
    {
        String sql = "DELETE FROM Payment WHERE Email=?";
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