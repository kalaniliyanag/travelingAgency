package TravellingAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainScreenCustomer extends JFrame
{
    private JPanel titleBar;
    private JPanel inputPanel;
    private JPanel tablePanel;
    private JPanel btnPanel;
    private JButton addButton,deleteButton,updateButton,nextButton,backButton;
    public MainScreenCustomer() throws HeadlessException
    {
        this("Customer Details Application");
    }
    public MainScreenCustomer(String title) throws HeadlessException
    {
        super(title);
        titleBar=new TitlePanelCustomer();
        inputPanel=new InputPanelCustomer();
        tablePanel = new DatabaseCustomerTablePanel();

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        nextButton = new JButton("Next");
        backButton = new JButton("Back");
        initializeUI();
    }
    private void initializeUI()
    {
        Container container=getContentPane();
        container.setLayout(new BorderLayout());

        JPanel titleBarAndInputPanel = new JPanel();

        //Creates anew panel to include title panel and input panel
        titleBarAndInputPanel.setLayout(new BorderLayout());
        titleBarAndInputPanel.add(titleBar,BorderLayout.NORTH);
        titleBarAndInputPanel.add(inputPanel,BorderLayout.CENTER);

        container.add(titleBarAndInputPanel,BorderLayout.NORTH);

        container.add(tablePanel,BorderLayout.CENTER);
        //Adding Button panel to south
        JPanel btnPanel = new JPanel();
        btnPanel.add(addButton);
        btnPanel.add(deleteButton);
        btnPanel.add(updateButton);
        btnPanel.add(nextButton);
        btnPanel.add(backButton);

        //Handling add event using anonymous class
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField FnameTextField = new JTextField();
                JTextField LnameTextField = new JTextField();
                JTextField EmailTextField = new JTextField();
                JTextField ContactNOField = new JTextField();

                //Create a components array
                //Inside this array it have 8 components(4 textfield and 4 labels)
                Component[] components = inputPanel.getComponents();
                for(Component cmp: components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("FNameFieldName"))
                    {
                        FnameTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("LNameFieldName"))
                    {
                        LnameTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("EmailFieldName"))
                    {
                        EmailTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("ContactNumberFieldName"))
                    {
                        ContactNOField = (JTextField) cmp;
                    }
                }
                if (FnameTextField.getText().isEmpty() || LnameTextField.getText().isEmpty() ||
                        EmailTextField.getText().isEmpty() || ContactNOField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(btnPanel,"All Fields must be filled");
                }
                else
                {
                    System.out.println(FnameTextField.getText());
                    System.out.println(LnameTextField.getText());
                    System.out.println(EmailTextField.getText());
                    System.out.println(ContactNOField.getText());
                    try {
                        String FirstName = FnameTextField.getText().trim();
                        //Triming means reserving extra spaces
                        String LastName = LnameTextField.getText().trim();
                        String Email = EmailTextField.getText().trim();
                        int ContactNumber = Integer.valueOf(ContactNOField.getText().trim());

                        DatabaseOperationCustomer databaseOperationCustomer= new DatabaseOperationCustomer();
                        databaseOperationCustomer.addCustomer(FirstName,LastName,Email,ContactNumber);

                        JOptionPane.showMessageDialog(tablePanel, "Customer Details successful.");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreenVehicle VehicleForm = new MainScreenVehicle();
                VehicleForm.setVisible(true);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreenVehicle home = new MainScreenVehicle();
                home.setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JTextField FnameTextField = new JTextField();
                JTextField LnameTextField = new JTextField();
                JTextField EmailTextField = new JTextField();
                JTextField ContactNOField = new JTextField();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("FNameFieldName"))
                    {
                        FnameTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("LNameFieldName"))
                    {
                        LnameTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("EmailFieldName"))
                    {
                        EmailTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("ContactNumberFieldName"))
                    {
                        ContactNOField = (JTextField) cmp;
                    }
                }

                try
                {
                        String FirstName = FnameTextField.getText().trim();
                        //Triming means reserving extra spaces
                        String LastName = LnameTextField.getText().trim();
                        String Email = EmailTextField.getText().trim();
                        int ContactNumber = Integer.valueOf(ContactNOField.getText().trim());

                        DatabaseOperationCustomer databaseOperationCustomer= new DatabaseOperationCustomer();
                        databaseOperationCustomer.updateCustomer(FirstName,LastName,Email,ContactNumber);

                    JOptionPane.showMessageDialog(tablePanel, "Customer Details Update successful.");

                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage home= new HomePage();
                home.setVisible(true);
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

                    DatabaseOperationCustomer databaseOperationCustomer= new DatabaseOperationCustomer();
                    databaseOperationCustomer.deleteCustomer(Email);

                    JOptionPane.showMessageDialog(tablePanel, "Customer Details Delete successful.");

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
        new MainScreenCustomer();
    }
}