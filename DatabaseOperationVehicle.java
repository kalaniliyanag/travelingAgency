package TravellingAgency;

import java.sql.*;

public class DatabaseOperationVehicle
{
    private Connection connection;
    private Statement statement;
    private String ConnectionUrl="jdbc:mysql://localhost:3306/traveling_agency";

    public DatabaseOperationVehicle() throws SQLException
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
    public void addVehicle(String VehicleId,String Model,String Status, int tourid)
    {
        String sql="INSERT INTO Vehicle(Vehicleid,Model,Status,tourid) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement=null;

        try{
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1,VehicleId);
            preparedStatement.setString(2,Model);
            preparedStatement.setString(3,Status);
            preparedStatement.setInt(4,tourid);
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

    public void deleteVehicle(String VehicleId)
    {
        String sql = "DELETE FROM Vehicle WHERE Vehicleid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,VehicleId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("No record found with DoctorId: " + VehicleId);
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

    public void updateVehicle(String VehicleId,String Model,String Status, int tourid)
    {
        String sql = "UPDATE Vehicle SET Model=?, Status=?, tourid=? WHERE Vehicleid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Model);
            preparedStatement.setString(2, Status);
            preparedStatement.setInt(3, tourid);
            preparedStatement.setString(4,VehicleId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("No record found with DoctorId: " + VehicleId);
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
