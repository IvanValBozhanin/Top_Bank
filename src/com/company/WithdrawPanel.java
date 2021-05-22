package com.company;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class WithdrawPanel extends JFrame {
    //initialization
    private JLabel withdrawLabel;
    private JButton withdrawButton;
    private JButton exitButton;
    private JLabel bankIcon;
    private JPanel jPanel;
    private JTextField enterSum;

    public WithdrawPanel() {
        // window parameters
        setResizable(false);
        setSize(450, 260);
        setVisible(true);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);


        /**
         * konst@tninte, komentarite!!!???@@!
         *
         */
        // bank logo stuff
        bankIcon = new JLabel(new ImageIcon("TopBank.png"));
        bankIcon.setBounds(20, 10, 215, 103);

        // grid panel
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2));

        // declaration of the parameters
        enterSum = new JTextField(15);
        withdrawLabel = new JLabel("Sum to be withdrawn:");

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            User.users.get(User.currentUserPosition).withdraw(Double.parseDouble(enterSum.getText()));
            enterSum.setText("");
            try {
                User.updateUsers();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        exitButton = new JButton("Exit page");
        exitButton.addActionListener(e -> {
            new UserHomePage(User.currentUserPosition);
            dispose();
        });

        // adding them to the panel in the correct order
        jPanel.add(withdrawLabel);
        jPanel.add(enterSum);
        jPanel.add(exitButton);
        jPanel.add(withdrawButton);
        // insertion of the icon and panel into the frame
        add(bankIcon);
        add(jPanel);
    }
}