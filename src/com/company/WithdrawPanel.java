package com.company;
import java.awt.*;

import javax.swing.*;

public class WithdrawPanel extends JFrame {
    //initialization
    private JLabel labelY;
    private JButton dep;
    private JButton exit;
    private JLabel icon;
    private JPanel e;
    private JTextField textField1;

    public WithdrawPanel() {
        // window parameters
        setSize(450, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        // bank logo stuff
        icon = new JLabel(new ImageIcon("TopBank.png"));
        icon.setBounds(20, 10, 215, 103);

        // grid panel
        e = new JPanel();
        e.setLayout(new GridLayout(2, 2));

        // declaration of the parameters
        textField1 = new JTextField(15);
        labelY = new JLabel("Sum to be withdrawn:");
        dep = new JButton("Withdraw");
        exit = new JButton("Exit page");

        // adding them to the panel in the correct order
        e.add(labelY);
        e.add(textField1);
        e.add(exit);
        e.add(dep);
        // insertion of the icon and panel into the frame
        add(icon);
        add(e);
    }
}