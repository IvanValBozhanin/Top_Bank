package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import static com.company.User.updateUsers;
import static com.company.User.users;

public class NewUser extends JFrame{

    // initializing all frames, textFields, buttons, and labels as well as an ImageIcon
    public JFrame frame;
    private JTextField textName, textPass, textUser;
    private JButton register;
    private JLabel nameLabel, passLabel, userLabel, imgLabel;
    private ImageIcon topBank;

    public NewUser() { // create a constructor for the starting panel
        super("NewUserPage"); // use the constructor for the superclass JFrame to create a panel
        frame = new JFrame(); // declare the JFrame

        setLayout( new FlowLayout() ); // set the layout to be a flow layout

        // set the image icon to be the one of TopBank and then transfer it to a JLabel so we can add it to the frame
        ImageIcon topBank = new ImageIcon("TopBank.png");
        imgLabel = new JLabel(topBank);
        imgLabel.setBounds(10, 10, 250, 100);

        // set the text, font, orientation and position for the real name label
        nameLabel = new JLabel("Real Name:");
        nameLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        nameLabel.setBounds(30, 100, 100, 110);

        // set the font, orientation and position for the real name text field
        textName = new JTextField();
        textName.setFont(new Font("Serif", Font.ITALIC, 20));
        textName.setBounds(125, 140, 300, 30);

        // set the text, font, orientation and position for the user name label
        userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        userLabel.setBounds(30, 150, 100, 110);

        // set the font, orientation and position for the real name text field
        textUser = new JTextField();
        textUser.setFont(new Font("Serif", Font.ITALIC, 20));
        textUser.setBounds(125, 190, 300, 30);

        // set the text, font, orientation and position for the password label
        passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        passLabel.setBounds(30, 200, 100, 110);

        // set the font, orientation and position for the password text field
        textPass = new JPasswordField();
        textPass.setFont(new Font("Serif", Font.ITALIC, 20));
        textPass.setBounds(125, 240, 300, 30);

        // set the text, font, orientation and position for the register button
        register = new JButton("Register");
        register.setFont(new Font("Serif", Font.ITALIC, 20));
        register.setBounds(200, 290, 130, 30);
        register.addActionListener(e -> {
            /**
             * exception(s) needed
             */
            User user = new User(textName.getText(), textUser.getText(), textPass.getText(), 0.0);
            users.add(user);
            System.out.printf("%s; %s; %s\n", textName.getText(), textUser.getText(), textPass.getText());

            try {
                updateUsers();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            frame.dispose();
        });

        //add everything to the JFrame
        frame.add(imgLabel);
        frame.add(nameLabel);
        frame.add(textName);
        frame.add(userLabel);
        frame.add(textUser);
        frame.add(passLabel);
        frame.add(textPass);
        frame.add(register);

        //set the size, relative location, layout and visibility of the frame
        frame.setResizable(false);
        frame.setSize(530, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}