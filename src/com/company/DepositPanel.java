package com.company;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import static com.company.Main.*;

public class DepositPanel extends JFrame {
    //initialization
    private JLabel labelDeposit;
    private JButton depositButton;
    private JButton exitButton;
    private JLabel bankIcon;
    private JPanel jPanel;
    private JTextField enterSum;

    public DepositPanel() {
        // window parameters
        setSize(450, 260);
        setVisible(true);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        // bank logo stuff
        bankIcon = new JLabel(new ImageIcon("TopBank.png"));
        bankIcon.setBounds(20, 10, 215, 103);

        // grid panel
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2));

        // declaration of the parameters
        enterSum = new JTextField(15);
        labelDeposit = new JLabel("Sum to be deposited:");

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> {
            users.get(currentUserPosition).deposit(Double.parseDouble(enterSum.getText()));
            enterSum.setText("");
            try {
                updateUsers();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        exitButton = new JButton("Exit page");
        exitButton.addActionListener(e -> {
            new UserHomePage(currentUserPosition);
            dispose();
        });
        // adding them to the panel in the correct order
        jPanel.add(labelDeposit);
        jPanel.add(enterSum);
        jPanel.add(exitButton);
        jPanel.add(depositButton);
        // insertion of the icon and panel into the frame
        add(bankIcon);
        add(jPanel);
    }
}