package com.company;

import java.awt.*;

import javax.swing.*;

import static com.company.User.users;

public class UserHomePage extends JFrame {
    //initialization
    private JLabel nameLabel, balanceLabel, bankIcon;
    private String name;
    private double bal = 0;
    private JButton depositButton, withdrawButton, historyOfTransactionsButton, exitButton;

    private JPanel jButtonPanel, jLabelPanel;

    public UserHomePage(int position) {
        //basic window parameter stuff
        setResizable(false);
        setSize(450, 260);
        setVisible(true);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        //adding bank logo to frame
        bankIcon = new JLabel(new ImageIcon("TopBank.png"));
        bankIcon.setBounds(20, 10, 215, 103);
        add(bankIcon);

        //two new panels to unite some bits for a better view
        jButtonPanel = new JPanel();
        jLabelPanel = new JPanel();
        jLabelPanel.setLayout(new GridLayout(3,1 ));
        jButtonPanel.setLayout(new GridLayout(1, 3));

        //declaration of the components
        /**
         * needs formatting
         */
        nameLabel = new JLabel("Name:" + users.get(position).getName());

        /**
         * formatting
         */
        balanceLabel = new JLabel("Sum:" + users.get(position).getBalance());

        /**
         * formatting
         */
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            new WithdrawPanel();
            dispose();
        });
        /**
         * formatting
         */
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> {
            new DepositPanel();
            dispose();
        });

        historyOfTransactionsButton = new JButton("Action History");
        historyOfTransactionsButton.addActionListener(e -> {
            new HistoryTransactionsPanel();
        });

        exitButton = new JButton("Exit page");
        exitButton.addActionListener(e -> {
            dispose();
        });

        //adding the components to their respective panels
        jButtonPanel.add(depositButton);
        jButtonPanel.add(withdrawButton);
        jButtonPanel.add(historyOfTransactionsButton);
        jLabelPanel.add(nameLabel);
        jLabelPanel.add(balanceLabel);
        jLabelPanel.add(exitButton);

        //adding the panels to the frame
        add(jButtonPanel);
        add(jLabelPanel);
    }
}