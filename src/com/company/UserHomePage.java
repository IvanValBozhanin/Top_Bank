package com.company;

import java.awt.*;

import javax.swing.*;

public class UserHomePage extends JFrame {
    //initialization
    private JLabel labelX;
    private JLabel labelY;
    private String ime = "Pesho";
    private double para = 0;
    private JButton dep;
    private JButton wdr;
    private JButton hstr;
    private JButton exit;

    private JLabel icon;

    private JPanel panelCenter;
    private JPanel e;

    public UserHomePage() {
        //basic window parameter stuff
        setSize(450, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        //adding bank logo to frame
        icon = new JLabel(new ImageIcon("TopBank.png"));
        icon.setBounds(20, 10, 215, 103);
        add(icon);
        //two new panels to unite some bits for a better view
        panelCenter = new JPanel();
        e = new JPanel();
        e.setLayout(new GridLayout(3,1 ));
        panelCenter.setLayout(new GridLayout(1, 3));
        //declaration of the components
        labelX = new JLabel("Name:" + ime);
        labelY = new JLabel("Sum:" + para);
        wdr = new JButton("Withdraw");
        dep = new JButton("Deposit");
        hstr = new JButton("Action History");
        exit = new JButton("Exit page");
        //adding the components to their respective panels
        panelCenter.add(dep);
        panelCenter.add(wdr);
        panelCenter.add(hstr);
        e.add(labelX);
        e.add(labelY);
        e.add(exit);
        //adding the panels to the frame
        add(panelCenter);
        add(e);
    }
}