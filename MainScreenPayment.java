package TravellingAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class MainScreenPayment extends JFrame {
    private JPanel titleBar;
    private JPanel inputPanel;
    private JPanel tablePanel;
    private JPanel btnPanel;
    private JButton addButton, deleteButton, updateButton, nextButton, backButton;

    public MainScreenPayment() throws HeadlessException {
        this("Payment Details Application");
    }

    public MainScreenPayment(String title) throws HeadlessException {
        super(title);
        titleBar = new TitlePanelPayment();
        inputPanel = new InputPanelPayment();
        tablePanel = new DatabasePaymentTablePanel();

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        nextButton = new JButton("Next");
        backButton = new JButton("Back");
        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel titleBarAndInputPanel = new JPanel();

        //Creates anew panel to include title panel and input panel
        titleBarAndInputPanel.setLayout(new BorderLayout());
        titleBarAndInputPanel.add(titleBar, BorderLayout.NORTH);
        titleBarAndInputPanel.add(inputPanel, BorderLayout.CENTER);

        container.add(titleBarAndInputPanel, BorderLayout.NORTH);

        container.add(tablePanel, BorderLayout.CENTER);

        //Adding Button panel to south
        JPanel btnPanel = new JPanel();
        btnPanel.add(addButton);
        btnPanel.add(deleteButton);
        btnPanel.add(updateButton);
        btnPanel.add(nextButton);
        btnPanel.add(backButton);

        //Handling add event using anonymous class
        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField PayDateTextField = new JTextField();
                JTextField PaymentAmountTextField = new JTextField();
                JTextField DescriptionTextField = new JTextField();
                JTextField EmailTextField = new JTextField();

                //Create a components array
                //Inside this array it have 8 components(4 textfield and 4 labels)
                Component[] components = inputPanel.getComponents();
                for(Component cmp: components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("PayDateFieldName"))
                    {
                        PayDateTextField  = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("PaymentAmountFieldName"))
                    {
                        PaymentAmountTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("DescriptionFieldName"))
                    {
                        DescriptionTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("EmailFieldName"))
                    {
                        EmailTextField = (JTextField) cmp;
                    }

                }
                if (PayDateTextField.getText().isEmpty() || PaymentAmountTextField.getText().isEmpty() ||
                        DescriptionTextField.getText().isEmpty() || EmailTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(btnPanel,"All Fields must be filled");
                }
                else
                {
                    System.out.println(PayDateTextField.getText());
                    System.out.println(PaymentAmountTextField.getText());
                    System.out.println(DescriptionTextField.getText());
                    System.out.println(EmailTextField.getText());
                    try {
                        String PayDate = PayDateTextField.getText().trim();
                        //Triming means reserving extra spaces
                        int PaymentAmount = Integer.valueOf(PaymentAmountTextField.getText().trim());
                        String Description = DescriptionTextField.getText().trim();
                        String Email = EmailTextField.getText().trim();

                        DatabaseOperationPayment databaseOperationPayment= new DatabaseOperationPayment();
                        databaseOperationPayment.addPayment(PayDate,PaymentAmount,Description,Email);

                        JOptionPane.showMessageDialog(tablePanel, "Payment successful.");

                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switching to the next form (replace NextForm with your actual next form)
                HomePage home = new HomePage();
                home.setVisible(true);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switching to the next form (replace NextForm with your actual next form)
                HomePage home = new HomePage();
                home.setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JTextField PayDateTextField = new JTextField();
                JTextField PaymentAmountTextField = new JTextField();
                JTextField DescriptionTextField = new JTextField();
                JTextField EmailTextField = new JTextField();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("PayDateFieldName"))
                    {
                        PayDateTextField  = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("PaymentAmountFieldName"))
                    {
                        PaymentAmountTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("DescriptionFieldName"))
                    {
                        DescriptionTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("EmailFieldName"))
                    {
                        EmailTextField = (JTextField) cmp;
                    }
                }

                try
                {
                    String PayDate = PayDateTextField.getText().trim();
                    //Triming means reserving extra spaces
                    int PaymentAmount = Integer.valueOf(PaymentAmountTextField.getText().trim());
                    String Description = DescriptionTextField.getText().trim();
                    String Email = EmailTextField.getText().trim();

                    // Get other updated values (if any)

                    DatabaseOperationPayment databaseOperationsPayment = new DatabaseOperationPayment();
                    databaseOperationsPayment.updatePayment(PayDate,PaymentAmount,Description,Email);

                    JOptionPane.showMessageDialog(tablePanel, "Payment Details Update successful.");

                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JTextField EmailTextField = new JTextField();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("EmailFieldName"))
                    {
                        EmailTextField = (JTextField) cmp;
                    }
                }

                try
                {

                    String Email = EmailTextField.getText().trim();

                    // Get other updated values (if any)

                    DatabaseOperationPayment databaseOperationsPayment = new DatabaseOperationPayment();
                    databaseOperationsPayment.deletePayment(Email);

                    JOptionPane.showMessageDialog(tablePanel, "Payment Details Delete successful.");

                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        container.add(btnPanel,BorderLayout.SOUTH);

        setSize(1300, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args)
    {
        new MainScreenPayment();
    }
}