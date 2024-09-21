package TravellingAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanelCustomer extends JPanel
{
    private JButton addButton, updateButton, deleteButton , nextButton, backButton;

    public ButtonPanelCustomer()
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
        //setBackground(new Color(40,50,60));
        InputPanelCustomer inputPanel=new InputPanelCustomer();
        JTextField fnameField = inputPanel.getFNameField();
        JTextField lnameField = inputPanel.getLNameField();
        JTextField emailField = inputPanel.getEmailField();
        JTextField numField = inputPanel.getContactNumberField();
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