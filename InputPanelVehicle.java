package TravellingAgency;

import javax.swing.*;
import java.awt.*;

public class InputPanelVehicle extends JPanel
{
    private JLabel Vehicleid,Model,Status,Tourid;
    private JTextField VehicleidField,TouridField;
    private JComboBox ModelBox,StatusBox;

    public InputPanelVehicle()
    {
        setLayout(new GridLayout(4,6,5,10));
        Vehicleid= new JLabel("Vehicle Id:");
        Model = new JLabel("Model:");
        Status = new JLabel("Status:");
        Tourid = new JLabel("Tour Id:");
        Model = new JLabel("Model:");
        Status = new JLabel("Status:");

        VehicleidField = new JTextField(13);
        VehicleidField.setName("VehicleIdName");

        TouridField = new JTextField(13);
        TouridField.setName("TourIdName");

        ModelBox=new JComboBox<>();
        ModelBox.setName("ModelName");

        StatusBox = new JComboBox<>();
        StatusBox.setName("StatusName");

        add(Vehicleid); //row 1 column 1
        add(VehicleidField); //row 1 column 2
        add(Model);
        add(ModelBox);
        add(Status);
        add(StatusBox);
        add(Tourid); //row 2 column 1
        add(TouridField); //row 2 column 2

        //Add items to combo Boxes
        String[] Model={"Honda","Toyota","Hybrid"};
        String[] Status={"Active","Booked"};

        for(String model : Model)
        {
            ModelBox.addItem(model);
        }
        for(String status : Status)
        {
            StatusBox.addItem(status);
        }
    }

    public JTextField getVehicleidField() {
        return VehicleidField;
    }

    public JComboBox getModelBox() {
        return ModelBox;
    }

    public JComboBox getStatusBox() {
        return StatusBox;
    }

    public JTextField getTouridField() {
        return TouridField;
    }
}
