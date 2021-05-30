package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import static com.company.User.users;
import static com.company.User.currentUserPosition;

public class StartPanel extends JFrame {

    // initializing all frames, textFields, buttons, and labels as well as an ImageIcon
    private final Font SERIF = new Font("Serif", Font.ITALIC, 20);
    public JFrame frame;
    private JTextField textName, textPass;
    private JButton logIn, newUser;
    private JLabel nameLabel, passLabel, imgLabel, errorLogIn;

    public StartPanel() throws IOException { // create a constructor for the starting panel
        super("FrontPage"); // use the constructor for the superclass JFrame to create a panel
        frame = new JFrame(); // declare the JFrame

        //retrieving all the information saved in the source file
        restoreDataFromFile();

        setLayout(new FlowLayout()); // set the layout to be a flow layout

        // set the image icon to be the one of TopBank and then transfer it to a JLabel so we can add it to the frame
        ImageIcon topBank = new ImageIcon("TopBank.png");
        imgLabel = new JLabel(topBank);
        imgLabel.setBounds(10, 10, 250, 100);

        //set the text, font, orientation, and position for the error message
        errorLogIn = new JLabel("Please, fill out all fields.");
        errorLogIn.setFont(SERIF);
        errorLogIn.setBounds(250, 10, 300, 50);
        errorLogIn.setVisible(false);

        // set the text, font, orientation and position for the user name label
        nameLabel = new JLabel("Username:");
        nameLabel.setFont(SERIF);
        nameLabel.setBounds(30, 100, 100, 110);

        // set the font, orientation and position for the user name text field
        textName = new JTextField();
        textName.setFont(SERIF);
        textName.setBounds(125, 140, 300, 30);

        // set the text, font, orientation and position for the password label
        passLabel = new JLabel("Password:");
        passLabel.setFont(SERIF);
        passLabel.setBounds(30, 150, 100, 110);

        // set the font, orientation and position for the password field which hides its text
        textPass = new JPasswordField();
        textPass.setFont(SERIF);
        textPass.setBounds(125, 190, 300, 30);

        // set the text, font, orientation, position, and function for log in button
        logIn = new JButton("Log in");
        logIn.setFont(SERIF);
        logIn.setBounds(150, 250, 100, 30);
        logIn.addActionListener(e -> {
            validateLogIn();
        });

        // set the text, font, orientation, position, and function for the new user button
        newUser = new JButton("New User");
        newUser.setFont(SERIF);
        newUser.setBounds(270, 250, 120, 30);
        newUser.addActionListener(e -> {
            new NewUser();
        });

        //add everything to the JFrame
        frame.add(imgLabel);
        frame.add(nameLabel);
        frame.add(textName);
        frame.add(passLabel);
        frame.add(textPass);
        frame.add(logIn);
        frame.add(newUser);
        frame.add(errorLogIn);

        //set the size, relative location, layout and visibility of the frame
        frame.setResizable(false);
        frame.setSize(550, 350);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    //checks for correctness of the entered information
    private void validateLogIn() {
        if(textName.getText().isBlank() || textPass.getText().isEmpty()){
            errorLogIn.setText("Please, fill out all fields.");
            errorLogIn.setVisible(true);
        }
        else {
            boolean foundUser = false;
            for (int i = 0; i < users.size(); ++i) {
                if (users.get(i).getUsername().equals(textName.getText()) &&
                        users.get(i).getPassword().equals(textPass.getText())) {
                    foundUser = true;
                    currentUserPosition = i;
                    System.out.println(currentUserPosition);
                    new UserHomePage(currentUserPosition);
                    frame.dispose();
                }
            }
            if(!foundUser){
                errorLogIn.setText("Incorrect username or password.");
                errorLogIn.setVisible(true);
            }
        }
    }

    //restores information from the file
    private void restoreDataFromFile() throws IOException {
        File file = new File("src.dat");
        if (file.length() != 0) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src.dat"))) {
                try {
                    for (; ; ) {
                        User user = (User) in.readObject();
                        System.out.println(user.toString());
                        users.add(user);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (EOFException e) {
                    System.out.println("===read all===");
                }
            }
        }
    }
}