package TravellingAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainScreenTour extends JFrame
{
    private JPanel titleBar;
    private JPanel inputPanel;
    private JPanel tablePanel;
    private JPanel btnPanel;
    private JButton addButton,deleteButton,updateButton,nextButton,backButton;
    public MainScreenTour() throws HeadlessException
    {
        this("Tour Details Application");
    }
    public MainScreenTour(String title) throws HeadlessException
    {
        super(title);
        titleBar=new TitlePanelTour();
        inputPanel=new InputPanelTour();
        tablePanel = new DatabaseTourTablePanel();

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
                JTextField DescriptionTextField = new JTextField();
                JTextField StartLocationTextField = new JTextField();
                JTextField PayidTextField = new JTextField();
                JTextField CusidTextField = new JTextField();

                //Create a components array
                //Inside this array it have 8 components(4 text field and 4 labels)
                Component[] components = inputPanel.getComponents();
                for(Component cmp: components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("DescriptionFieldName"))
                    {
                        DescriptionTextField  = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("StartLocationFieldName"))
                    {
                        StartLocationTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("PayidFieldName"))
                    {
                        PayidTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("CusidFieldName"))
                    {
                        CusidTextField = (JTextField) cmp;
                    }

                }
                if (DescriptionTextField .getText().isEmpty() || StartLocationTextField.getText().isEmpty() ||
                        PayidTextField.getText().isEmpty() || CusidTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(btnPanel,"All Fields must be filled");
                }
                else
                {
                    System.out.println(DescriptionTextField.getText());
                    System.out.println(StartLocationTextField.getText());
                    System.out.println(PayidTextField.getText());
                    System.out.println(CusidTextField.getText());
                    try {
                        String Description = DescriptionTextField.getText().trim();
                        String StartLocation = StartLocationTextField.getText().trim();
                        //Triming means reserving extra spaces
                        int Payid = Integer.valueOf(PayidTextField.getText().trim());
                        int Cusid = Integer.valueOf(CusidTextField.getText().trim());

                        DatabaseOperationTour databaseOperationTour= new DatabaseOperationTour();
                        databaseOperationTour.addTour(Description,StartLocation,Payid,Cusid);

                        JOptionPane.showMessageDialog(tablePanel, "Tour Details successful.");

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
                MainScreenPayment PaymentForm= new MainScreenPayment();
                PaymentForm.setVisible(true);
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

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JTextField DescriptionTextField = new JTextField();
                JTextField StartLocationTextField = new JTextField();
                JTextField PayidTextField = new JTextField();
                JTextField CusidTextField = new JTextField();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("DescriptionFieldName"))
                    {
                        DescriptionTextField  = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("StartLocationFieldName"))
                    {
                        StartLocationTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("PayidFieldName"))
                    {
                        PayidTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("CusidFieldName"))
                    {
                        CusidTextField = (JTextField) cmp;
                    }
                }

                try
                {
                    String Description = DescriptionTextField.getText().trim();
                    String StartLocation = StartLocationTextField.getText().trim();
                    //Triming means reserving extra spaces
                    int Payid = Integer.valueOf(PayidTextField.getText().trim());
                    int Cusid = Integer.valueOf(CusidTextField.getText().trim());

                    // Get other updated values (if any)

                    DatabaseOperationTour databaseOperationstour = new DatabaseOperationTour();
                    databaseOperationstour.updateTour(Description, StartLocation, Payid, Cusid);

                    JOptionPane.showMessageDialog(tablePanel, "Tour Details Update successful.");

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
        new MainScreenTour();
    }
}