package TravellingAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame
{
    private JButton CustomerDetailsButton,VehicleDetailsButton,TourDetailsButton,PaymentDetailsButton,exitButton;

    public HomePage() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("C:\\EAD1\\Java Activity\\Packages\\src\\TravellingAgency\\Home.jpg");
                g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };
        panel.setBounds(0, 0, 1300, 700); // set bounds to match frame size
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(555, 600, 160, 40);
        exitButton.setForeground(Color.BLACK);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        
        JButton CustomerDetailsButton = new JButton("Customer Details");
        CustomerDetailsButton.setBounds(250, 100, 160, 40);
        CustomerDetailsButton.setForeground(Color.BLACK);
        CustomerDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement booking details functionality
                MainScreenCustomer customer = new MainScreenCustomer();
                customer.setVisible(true);
            }
        });
        panel.add(CustomerDetailsButton);

        JButton VehicleDetailsButton = new JButton("Vehicle Details");
        VehicleDetailsButton.setBounds(450, 100, 160, 40);
        VehicleDetailsButton.setForeground(Color.BLACK);
        VehicleDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement motorcycle details functionality
                MainScreenVehicle vehicle = new MainScreenVehicle();
                vehicle.setVisible(true);
            }
        });
        panel.add(VehicleDetailsButton);

        JButton TourDetailsButton = new JButton("Tour Details");
        TourDetailsButton.setBounds(650, 100, 160, 40);
        TourDetailsButton.setForeground(Color.BLACK);
        TourDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement repair details functionality
                MainScreenTour tour = new MainScreenTour();
                tour.setVisible(true);
            }
        });
        panel.add(TourDetailsButton);

        JButton PaymentDetailsButton = new JButton("Payment Details");
        PaymentDetailsButton.setBounds(850, 100, 160, 40);
        PaymentDetailsButton.setForeground(Color.BLACK);
        PaymentDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement customer details functionality
                MainScreenPayment payment = new MainScreenPayment();
                payment.setVisible(true);
            }
        });
        panel.add(PaymentDetailsButton);

        JLabel descriptionLabel = new JLabel("<html><div style='text-align: center;'>Discover the world with ease. "
                + "Form dream destinations to unforgettable adventures, we craft personalized journeys tailored to your desires."
                + "Let us turn your travel dreams into reality.</div></html>");
        descriptionLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        descriptionLabel.setBounds(300, 500, 700, 100);
        descriptionLabel.setForeground(Color.WHITE);
        panel.add(descriptionLabel);

        JLabel titleLabel = new JLabel("VEHICLE BOOKING SYSTEM");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(400, 10, 450, 100);
        panel.add(titleLabel);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePage homePage = new HomePage();
            homePage.setVisible(true);
        });
    }
}