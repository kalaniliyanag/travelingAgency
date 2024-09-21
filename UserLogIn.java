package TravellingAgency;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLogIn extends JFrame {
    private JPanel panel;
    private JLabel lblUserName, lblPassword ,title;
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JButton btnLogIn;

    public UserLogIn()
    {
        setTitle("User LogIn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("C:\\EAD1\\Java Activity\\Packages\\src\\TravellingAgency\\Trveling Image.jpg");
                g.drawImage(img.getImage(), 0, 0, 1500, 800, null);

                JLabel titleLabel = new JLabel("Sign In Form");
                titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
                titleLabel.setHorizontalAlignment(JLabel.CENTER);
                titleLabel.setVerticalAlignment(JLabel.TOP);
                titleLabel.setForeground(Color.BLACK);
                titleLabel.setBounds(400, 50, 450, 100);
                panel.add(titleLabel);
            }
        };
        panel.setBounds(0, 0, 1500, 800);
        getContentPane().add(panel);
        panel.setLayout(null);

        lblUserName = new JLabel("User Name:");
        lblUserName.setBounds(50, 150, 100, 30);
        lblUserName.setFont(new Font("Serif", Font.PLAIN, 20));
        lblUserName.setForeground(Color.WHITE); // Set font color to white
        panel.add(lblUserName);

        txtUserName = new JTextField();
        txtUserName.setBounds(200, 150, 300, 30);
        panel.add(txtUserName);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 200, 100, 30);
        lblPassword.setFont(new Font("Serif", Font.PLAIN, 20));
        lblPassword.setForeground(Color.WHITE); // Set font color to white
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(200, 200, 300, 30);
        panel.add(txtPassword);

        btnLogIn = new JButton("Log In");
        btnLogIn.setBounds(200, 250, 100, 30);
        btnLogIn.setForeground(Color.BLACK);

        btnLogIn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        btnLogIn.setForeground(Color.BLACK); // Set font color to white
        panel.add(btnLogIn);
    }

    private void loginUser() {
        String Username = txtUserName.getText();
        String password = new String(txtPassword.getPassword());

        // Validate input fields
        if (Username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/traveling_agency", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM User WHERE Username='" + Username + "' AND pswrd='" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next())
            {
                JOptionPane.showMessageDialog(this, "Sign In successful.");
                HomePage home = new HomePage();
                home.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Invalid name or password.");
            }

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserLogIn login = new UserLogIn();
            login.setVisible(true);
        });
    }
}