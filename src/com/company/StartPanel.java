package com.company;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JFrame {

    // initializing all frames, textFields, buttons, and labels as well as an ImageIcon
    public JFrame frame;
    private JTextField textName;
    private JPasswordField textPass;
    private JButton logIn;
    private JButton newUser;
    private JLabel nameLabel;
    private JLabel passLabel;
    private ImageIcon topBank;
    private JLabel imgLabel;

    public StartPanel() { // create a constructor for the starting panel
        super("FrontPage"); // use the constructor for the superclass JFrame to create a panel
        frame = new JFrame(); // declare the JFrame

        setLayout( new FlowLayout() ); // set the layout to be a flow layout

        // set the image icon to be the one of TopBank and then transfer it to a JLabel so we can add it to the frame
        ImageIcon topBank = new ImageIcon("TopBank.png");
        imgLabel = new JLabel(topBank);
        imgLabel.setBounds(10, 10, 250, 100);

        // set the text, font, orientation and position for the user name label
        nameLabel = new JLabel("Username:");
        nameLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        nameLabel.setBounds(30, 100, 100, 110);

        // set the font, orientation and position for the user name text field
        textName = new JTextField();
        textName.setFont(new Font("Serif", Font.ITALIC, 20));
        textName.setBounds(125, 140, 300, 30);

        // set the text, font, orientation and position for the password label
        passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        passLabel.setBounds(30, 150, 100, 110);

        // set the font, orientation and position for the password field which hides its text
        textPass = new JPasswordField();
        textPass.setFont(new Font("Serif", Font.ITALIC, 20));
        textPass.setBounds(125, 190, 300, 30);

        // set the text, font, orientation and position for log in button
        logIn = new JButton("Log in");
        logIn.setFont(new Font("Serif", Font.ITALIC, 20));
        logIn.setBounds(150, 250, 100, 30);

        // set the text, font, orientation and position for the new user button
        newUser = new JButton("New User");
        newUser.setFont(new Font("Serif", Font.ITALIC, 20));
        newUser.setBounds(270, 250, 120, 30);

        //add everything to the JFrame
        frame.add(imgLabel);
        frame.add(nameLabel);
        frame.add(textName);
        frame.add(passLabel);
        frame.add(textPass);
        frame.add(logIn);
        frame.add(newUser);

        //set the size, relative location, layout and visibility of the frame
        frame.setSize(530, 350);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}