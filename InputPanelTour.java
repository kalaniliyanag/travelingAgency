package TravellingAgency;

import javax.swing.*;
import java.awt.*;

public class InputPanelTour extends JPanel
{
    private JLabel Description,StartLocation,Payid,Cusid;
    private JTextField DescriptionField,StartLocationField,PayidField,CusidField;

    public InputPanelTour()
    {
        setLayout(new GridLayout(4,6,5,10));
        Description = new JLabel("Description:");
        StartLocation = new JLabel("Start Location:");
        Payid = new JLabel("Pay ID:");
        Cusid = new JLabel("Customer ID:");

        DescriptionField = new JTextField(13);
        DescriptionField.setName("DescriptionFieldName");

        StartLocationField = new JTextField(13);
        StartLocationField.setName("StartLocationFieldName");

        PayidField = new JTextField(13);
        PayidField.setName("PayidFieldName");

        CusidField = new JTextField(13);
        CusidField.setName("CusidFieldName");

        add(Description); //row 1 column 1
        add(DescriptionField); //row 1 column 2
        add(StartLocation);
        add(StartLocationField);
        add(Payid); //row 2 column 1
        add(PayidField); //row 2 column 2
        add(Cusid);
        add(CusidField);
    }
}