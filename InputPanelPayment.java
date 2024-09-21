package TravellingAgency;

import javax.swing.*;
import java.awt.*;

public class InputPanelPayment extends JPanel
{
    private JLabel PayDate,PaymentAmount,Description,Email;
    private JTextField PayDateField,PaymentAmountField,DescriptionField,EmailField;

    public InputPanelPayment()
    {
        setLayout(new GridLayout(4,6,5,10));
        PayDate = new JLabel("Payment Date:");
        PaymentAmount = new JLabel("Payment Amount:");
        Description = new JLabel("Description:");
        Email= new JLabel("Email:");

        PayDateField = new JTextField(13);
        PayDateField.setName("PayDateFieldName");

        PaymentAmountField = new JTextField(13);
        PaymentAmountField.setName("PaymentAmountFieldName");

        DescriptionField = new JTextField(13);
        DescriptionField.setName("DescriptionFieldName");

        EmailField = new JTextField(13);
        EmailField.setName("EmailFieldName");

        add(PayDate); //row 1 column 1
        add(PayDateField); //row 1 column 2
        add(PaymentAmount);
        add(PaymentAmountField);
        add(Description); //row 2 column 1
        add(DescriptionField); //row 2 column 2
        add(Email);
        add(EmailField);
    }

    public JTextField getEmailField() {
        return EmailField;
    }
    public JTextField getPayDateField() {
        return PayDateField;
    }

    public JTextField getPaymentAmountField() {
        return PaymentAmountField;
    }

    public JTextField getDescriptionField() {
        return DescriptionField;
    }
}
