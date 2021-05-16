package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HistoryTransactions extends JFrame {
    JFrame frame;
    JLabel icon;
    JButton switchTransactionSorting;
    boolean isSortedBySum = true;
    JTextArea area;
    ArrayList<Triplet> triplets = new ArrayList<>();


    public HistoryTransactions() throws IOException {
        super("History of Transactions");
        frame = new JFrame("History of Transactions");

        setLayout(new FlowLayout());
        icon = new JLabel(new ImageIcon("TopBank.png"));
        icon.setBounds(20, 10, 215, 103);

        switchTransactionSorting = new JButton("Sort by Date");
        switchTransactionSorting.setFont(new Font("Serif", Font.PLAIN, 20));
        switchTransactionSorting.setBounds(400, 30, 300, 30);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Serif", Font.PLAIN, 20));
        area.setBounds(20, 150, 740, 300);


        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("src.dat"))){
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
