package TravellingAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanelVehicle extends JPanel
{
    private JButton addButton, updateButton, deleteButton ,nextButton,backButton;

    public ButtonPanelVehicle()
    {
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        nextButton =  new JButton("Next");
        backButton = new JButton("Back");
        initializeUI();
    }

    private void initializeUI()
    {
        setBackground(new Color(50,50,60));
        InputPanelVehicle inputPanel=new InputPanelVehicle();
        JTextField VehicleidField = inputPanel.getVehicleidField();
        JComboBox ModelBox = inputPanel.getModelBox();
        JComboBox Status = inputPanel.getStatusBox();
        JTextField touridField = inputPanel.getTouridField();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Add Button Clicked");
            }
        });
        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(nextButton);
        add(backButton);
    }
}
