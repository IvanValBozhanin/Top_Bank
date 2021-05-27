package com.company;

import java.awt.*;

import javax.swing.*;

import static com.company.User.users;

public class UserHomePage extends JFrame {

    //declaration of the fields
    Font SERIF = new Font("Serif", Font.ITALIC, 20);
    private JLabel nameLabel, balanceLabel, bankIcon;
    private JButton depositButton, withdrawButton, historyOfTransactionsButton, exitButton;

    private JPanel jButtonPanel, jLabelPanel;

    public UserHomePage(int position) {
        //basic window parameter stuff
        setResizable(false);
        setSize(500, 260);
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

        //initialization of the Name label component
        nameLabel = new JLabel("Name:" + users.get(position).getName());

        nameLabel.setFont(SERIF);

        //initialization of the Balance label component
        balanceLabel = new JLabel("Sum:" + users.get(position).getBalance());
        balanceLabel.setFont(SERIF);

        //initialization of the Withdraw button component
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(SERIF);
        withdrawButton.addActionListener(e -> {
            new WithdrawPanel();
            dispose();
        });

        //initialization of the Deposit button component
        depositButton = new JButton("Deposit");
        depositButton.setFont(SERIF);
        depositButton.addActionListener(e -> {
            new DepositPanel();
            dispose();
        });


        //initialization of the History of transaction button component
        historyOfTransactionsButton = new JButton("Action History");
        historyOfTransactionsButton.setFont(SERIF);
        historyOfTransactionsButton.addActionListener(e -> new HistoryTransactionsPanel());

        //initialization of the Exit button component
        exitButton = new JButton("Exit page");
        exitButton.setFont(SERIF);
        exitButton.addActionListener(e -> dispose());

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