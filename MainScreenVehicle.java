package TravellingAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainScreenVehicle extends JFrame
{
    private JPanel titleBar;
    private JPanel inputPanel;
    private JPanel tablePanel;
    private JPanel btnPanel;
    private JButton addButton,deleteButton,updateButton,nextButton,backButton;
    public MainScreenVehicle() throws HeadlessException
    {
        this("Vehicle Details Application");
    }
    public MainScreenVehicle(String title) throws HeadlessException
    {
        super(title);
        titleBar=new TitlePanelVehicle();
        inputPanel=new InputPanelVehicle();
        tablePanel = new DatabaseVehicleTablePanel();

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

        //Creates a new panel to include title panel and input panel
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField VehicleTextField = new JTextField();
                JComboBox<String> ModelComboBox = new JComboBox<>();
                JComboBox<String> StatusComboBox = new JComboBox<>();
                JTextField touridTextField = new JTextField();

                //Created a component array
                //Inside this array it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("VehicleIdName"))
                    {
                        VehicleTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("ModelName"))
                    {
                        ModelComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("StatusName"))
                    {
                        StatusComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("TourIdName"))
                    {
                        touridTextField = (JTextField) cmp;
                    }
                }

                if (VehicleTextField.getText().isEmpty() || ModelComboBox.getSelectedItem() == null
                        || StatusComboBox.getSelectedItem() == null || touridTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(btnPanel, "All fields must be filled");
                }
                else
                {
                    System.out.println(VehicleTextField.getText());
                    System.out.println(ModelComboBox.getSelectedItem());
                    System.out.println(StatusComboBox.getSelectedItem());
                    System.out.println(touridTextField.getText());

                    try
                    {
                        String VehicleId = VehicleTextField.getText().trim();
                        String Model = ModelComboBox.getSelectedItem().toString().trim();
                        String Status = StatusComboBox.getSelectedItem().toString().trim();
                        int tourid = Integer.valueOf(touridTextField.getText().trim());

                        DatabaseOperationVehicle databaseOperationsVehicle = new DatabaseOperationVehicle();
                        databaseOperationsVehicle.addVehicle(VehicleId, Model,Status, tourid);

                        JOptionPane.showMessageDialog(tablePanel, "Vehicle Details successful.");

                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Handling next button event to switch to the next form
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreenTour TourForm= new MainScreenTour();
                TourForm.setVisible(true);
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
                JTextField VehicleTextField = new JTextField();
                JComboBox<String> ModelComboBox = new JComboBox<>();
                JComboBox<String> StatusComboBox = new JComboBox<>();
                JTextField touridTextField = new JTextField();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("VehicleIdName"))
                    {
                        VehicleTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("ModelName"))
                    {
                        ModelComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("StatusName"))
                    {
                        StatusComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("TourIdName"))
                    {
                        touridTextField = (JTextField) cmp;
                    }
                }

                try
                {
                    String VehicleId = VehicleTextField.getText().trim();
                    String Model = ModelComboBox.getSelectedItem().toString().trim();
                    String Status = StatusComboBox.getSelectedItem().toString().trim();
                    int tourid = Integer.valueOf(touridTextField.getText().toString().trim());

                    // Get other updated values (if any)

                    DatabaseOperationVehicle databaseOperationsVehicle = new DatabaseOperationVehicle();
                    databaseOperationsVehicle.updateVehicle(VehicleId, Model,Status, tourid);

                    JOptionPane.showMessageDialog(tablePanel, "Vehicle Details Update successful.");

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
                JTextField VehicleTextField = new JTextField();

                // Created a component array
                // Inside this array,
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("VehicleIdName"))
                    {
                        VehicleTextField = (JTextField) cmp;
                    }
                }

                try
                {
                    String VehicleId = VehicleTextField.getText().trim();


                    // Get other updated values (if any)

                    DatabaseOperationVehicle databaseOperationsVehicle = new DatabaseOperationVehicle();
                    databaseOperationsVehicle.deleteVehicle(VehicleId);

                    JOptionPane.showMessageDialog(tablePanel, "Vehicle Details Delete successful.");

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
        new MainScreenVehicle();
    }
}
