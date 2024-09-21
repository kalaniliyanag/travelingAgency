package TravellingAgency;

import javax.swing.*;
import java.awt.*;

public class InputPanelCustomer extends JPanel
{
    private JLabel FName,LName,Email,ContactNumber;
    private JTextField FNameField,LNameField,EmailField,ContactNumberField;

    public InputPanelCustomer()
    {
        setLayout(new GridLayout(4,6,5,10));
        FName = new JLabel("First Name:");
        LName = new JLabel("Last Name:");
        Email = new JLabel("Email:");
        ContactNumber = new JLabel("Contact Number:");

        FNameField = new JTextField(13);
        FNameField.setName("FNameFieldName");

        LNameField = new JTextField(13);
        LNameField.setName("LNameFieldName");

        EmailField = new JTextField(13);
        EmailField.setName("EmailFieldName");

        ContactNumberField = new JTextField(13);
        ContactNumberField.setName("ContactNumberFieldName");

        add(FName); //row 1 column 1
        add(FNameField); //row 1 column 2
        add(LName);
        add(LNameField);
        add(Email);
        add(EmailField);
        add(ContactNumber); //row 2 column 1
        add(ContactNumberField); //row 2 column 2
    }

    public JTextField getFNameField()
    {
        return FNameField;
    }

    public JTextField getLNameField()
    {
        return LNameField;
    }

    public JTextField getEmailField()
    {
        return EmailField;
    }

    public JTextField getContactNumberField()
    {
        return ContactNumberField;
    }
}