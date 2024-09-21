package TravellingAgency;

import javax.swing.*;
import java.awt.*;

public class TitlePanelCustomer extends JPanel
{
    private JLabel title;

    public TitlePanelCustomer()
    {
        this.title = new JLabel();
        setLayout(new BorderLayout());
        initializeTitleBarlUI();
    }
    private void initializeTitleBarlUI()
    {
        JPanel coloredPanel=new JPanel();
        title.setText("Customer Details");
        coloredPanel.setBackground(new Color(97,163,186));
        coloredPanel.add(title);

        JPanel emptyPanel=new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(),15));
        add(coloredPanel,BorderLayout.CENTER);
        add(emptyPanel,BorderLayout.SOUTH);
    }
}