package com.company;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class DepositPanel extends JFrame {

    //initialization of the fields
    private final Font SERIF = new Font("Serif", Font.ITALIC, 20);
    private JLabel labelDeposit, bankIcon;
    private JButton depositButton, exitButton;
    private JPanel jPanel;
    private JTextField enterSum;

    public DepositPanel() {
        // window parameters
        setResizable(false);
        setSize(500, 260);
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
        enterSum.setFont(SERIF);

        labelDeposit = new JLabel("Sum to be deposited:");
        labelDeposit.setFont(SERIF);

        depositButton = new JButton("Deposit");
        depositButton.setFont(SERIF);
        depositButton.addActionListener(e -> {
            depositFunction();
        });

        exitButton = new JButton("Exit page");
        exitButton.setFont(SERIF);
        exitButton.addActionListener(e -> {
            new UserHomePage(User.currentUserPosition);
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

    //deposit function which verifies or denies operation
    private void depositFunction() {
        try {
            User.users.get(User.currentUserPosition).deposit(Double.parseDouble(enterSum.getText()));
            enterSum.setText("");
            try {
                User.updateUsers();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (NumberFormatException exception){
            labelDeposit.setText("Please, enter a number.");
        }
    }
}