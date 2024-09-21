package TravellingAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanelPayment extends JPanel
{
    private JButton addButton, updateButton, deleteButton ,nextButton,backButton;

    public ButtonPanelPayment()
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
        InputPanelPayment inputPanel=new InputPanelPayment();
        JTextField payDateField = inputPanel.getPayDateField();
        JTextField payAmountField = inputPanel.getPaymentAmountField();
        JTextField descriptionField = inputPanel.getDescriptionField();
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
