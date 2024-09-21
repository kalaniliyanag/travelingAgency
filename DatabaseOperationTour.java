package TravellingAgency;

import jdk.jfr.Description;

import java.sql.*;

public class DatabaseOperationTour
{
    private Connection connection;
    private Statement statement;
    private String ConnectionUrl="jdbc:mysql://localhost:3306/traveling_agency";

    public DatabaseOperationTour() throws SQLException
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
    public void addTour(String Description,String StartLocation,int PayId, int CusId)
    {
        String sql="INSERT INTO Tour(Description,StartLocation,Payid,Cusid) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement=null;

        try{
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, Description);
            preparedStatement.setString(2, StartLocation);
            preparedStatement.setInt(3, PayId);
            preparedStatement.setInt(4, CusId);
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

    public void updateTour(String Description,String StartLocation,int PayId, int CusId)
    {
        String sql = "UPDATE Tour SET Description=?, StartLocation=?, Payid=? WHERE Cusid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Description);
            preparedStatement.setString(2, StartLocation);
            preparedStatement.setInt(3, PayId);
            preparedStatement.setInt(4,CusId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("No record found with CusId: " + CusId);
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