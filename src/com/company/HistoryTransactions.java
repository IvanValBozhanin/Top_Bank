package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HistoryTransactions extends JFrame {

    // initializing all frames, textFields, buttons, and labels as well as an ImageIcon
    JFrame frame;
    JLabel icon;
    JButton switchTransactionSorting;
    boolean isSortedBySum = true;
    JTextArea area;
    ArrayList<Triplet> triplets = new ArrayList<>();

    // create a constructor for the panel
    public HistoryTransactions() throws IOException {
        // use the constructor for the superclass JFrame to create a panel
        super("History of Transactions");
        // declare the JFrame
        frame = new JFrame("History of Transactions");

        // set the layout to be a flow layout
        setLayout(new FlowLayout());

        // set the image icon
        icon = new JLabel(new ImageIcon("TopBank.png"));
        icon.setBounds(20, 10, 215, 103);

        // set the text, font, orientation, and position for the register button
        switchTransactionSorting = new JButton("Sort by Date");
        switchTransactionSorting.setFont(new Font("Serif", Font.PLAIN, 20));
        switchTransactionSorting.setBounds(400, 30, 300, 30);

        // set the area for where the transactions will be displayed
        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Serif", Font.PLAIN, 20));
        area.setBounds(20, 150, 740, 300);


        /**
         * testing funcionality
         * try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("src.dat"))){
            try{
                for(;;){
                    User user = (User) in.readObject();
                    if(user.getName().equals("Ivan")){
                        ArrayList<Triplet> triplets = new ArrayList<>(user.getRegister());
                        triplets.sort(Comparator.comparingDouble(Triplet::getSum));
                        for (Triplet t :
                                triplets) {
                            area.append(t.getSum()+ " " + t.getDate()+ " "+ t.isWithdraw()+"\n");
                        }
                    }
                }
            }
            catch (InvalidClassException e){
                System.out.println("invalid");
            }
            catch (ClassNotFoundException e) {
                System.out.println("not found class");
            }
            catch (EOFException e){
                System.out.println("read all");
            }
        }
         */

        // add all components to the frame and adjusting its parameters
        {
            frame.add(icon);
            frame.add(switchTransactionSorting);
            frame.add(area);


            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);
            frame.setVisible(true);
        }
    }
}
