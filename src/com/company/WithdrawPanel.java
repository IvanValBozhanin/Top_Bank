package com.company;

import java.awt.*;
import java.io.IOException;
import java.security.InvalidParameterException;

import javax.swing.*;

public class WithdrawPanel extends JFrame {
    //declaration of the withdraw and exit buttons, the jpanel, the text field used for sum insertion, initialization AND declaration of the text font
    private final Font SERIF = new Font("Serif", Font.ITALIC, 20);
    private JLabel withdrawLabel, bankIcon;
    private JButton withdrawButton, exitButton;
    private JPanel jPanel;
    private JTextField enterSum;

    public WithdrawPanel() {
        // setting window parameters - opportunity of resizing, final size, layout
        setResizable(false);
        setSize(500, 260);
        setVisible(true);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        // declaration and initialization of the Bank logo as a JLabel, setting its position and size
        bankIcon = new JLabel(new ImageIcon("TopBank.png"));
        bankIcon.setBounds(20, 10, 215, 103);

        // grid panel 2x2, label and textbox up, buttons down
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2));

        // setting font, setting label's text, setting textfield size (15 letters), button names and action listeners
        enterSum = new JTextField(15);
        enterSum.setFont(SERIF);

        withdrawLabel = new JLabel("Sum to be withdrawn:");
        withdrawLabel.setFont(SERIF);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(SERIF);
        withdrawButton.addActionListener(e -> {
            withdrawFunction();
        });

        //exit button parameters
        exitButton = new JButton("Exit page");
        exitButton.setFont(SERIF);
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

    //withdraw function which verifies or denies the operation
    private void withdrawFunction() {
        try {
            User.users.get(User.currentUserPosition).withdraw(Double.parseDouble(enterSum.getText()));
            enterSum.setText("");
            try {
                User.updateUsers();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (NumberFormatException exception){
            withdrawLabel.setText("Please, enter a number.");
        } catch (InvalidParameterException exception){
            withdrawLabel.setText("Too much to withdraw.");
        }
    }
}