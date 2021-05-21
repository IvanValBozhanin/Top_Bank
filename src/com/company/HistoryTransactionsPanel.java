package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static com.company.Main.currentUserPosition;
import static com.company.Main.users;

public class HistoryTransactionsPanel extends JFrame {

    // initializing all frames, textFields, buttons, and labels as well as an ImageIcon
    JFrame frame;
    JLabel icon;
    JButton switchTransactionSorting, switchOrder, onlyWithdraw, onlyDeposit, both;
    boolean isSortedBySum = true, isLeastToLargest = true;
    JTextArea area;

    // create a constructor for the panel
    public HistoryTransactionsPanel(){
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
        switchTransactionSorting.setBounds(520, 30, 260, 30);

        Triplet [] triplets = users.get(currentUserPosition).getRegister().toArray(new Triplet[0]);
        switchTransactionSorting.addActionListener(e -> {
            isLeastToLargest = true;
            if(isSortedBySum){
                isSortedBySum = false;
                switchTransactionSorting.setText("Sort by Sum");
                switchOrder.setText("From Oldest to Newest");

                mergeSort(triplets, (t1, t2) -> {
                    if(t1.getDate().before(t2.getDate())){
                        return 1;
                    }
                    else if(t1.getDate().after(t2.getDate())){
                        return -1;
                    }
                    return 0;
                });

            }
            else{
                isSortedBySum = true;
                switchTransactionSorting.setText("Sort by Date");
                switchOrder.setText("From Largest to Smallest");

                mergeSort(triplets, (t1, t2) -> {
                    if(t1.getSum() > t2.getSum()){
                        return 1;
                    }
                    else if(t1.getSum() < t2.getSum()){
                        return -1;
                    }
                    return 0;
                });
            }
            area.setText("");
            for(Triplet triplet: triplets){
                area.append(triplet.toString() + "\n");
            }
        });

        switchOrder = new JButton("From Smallest to Largest");
        switchOrder.setFont(new Font("Serif", Font.PLAIN, 20));
        switchOrder.setBounds(520, 70, 260, 30);
        switchOrder.addActionListener(e -> {
            if(isSortedBySum){
                if(isLeastToLargest){
                    switchOrder.setText("From Smallest to Largest");
                }
                else {
                    switchOrder.setText("From Largest to Smallest");
                }
            }
            else{
                if(isLeastToLargest){
                    switchOrder.setText("From Newest to Oldest");
                }
                else{
                    switchOrder.setText("From Oldest to Newest");
                }
            }
            isLeastToLargest = !isLeastToLargest;
            Collections.reverse(Arrays.asList(triplets));
            area.setText("");
            for(Triplet triplet: triplets){
                area.append(triplet.toString() + "\n");
            }
        });

        onlyDeposit = new JButton("Only Deposits");
        onlyDeposit.setFont(new Font("Serif", Font.PLAIN, 20));
        onlyDeposit.setBounds(250, 20, 260, 30);
        onlyDeposit.addActionListener(e -> {
            area.setText("");
            for(Triplet triplet: triplets){
                if(!triplet.isWithdraw()) {
                    area.append(triplet.toString() + "\n");
                }
            }
        });

        onlyWithdraw = new JButton("Only Withdraws");
        onlyWithdraw.setFont(new Font("Serif", Font.PLAIN, 20));
        onlyWithdraw.setBounds(250, 55, 260, 30);
        onlyWithdraw.addActionListener(e -> {
            area.setText("");
            for(Triplet triplet: triplets){
                if(triplet.isWithdraw()) {
                    area.append(triplet.toString() + "\n");
                }
            }
        });

        both = new JButton("Deposits and Withdraws");
        both.setFont(new Font("Serif", Font.PLAIN, 20));
        both.setBounds(250, 90, 260, 30);
        both.addActionListener(e -> {
            area.setText("");
            for(Triplet triplet: triplets){
                area.append(triplet.toString() + "\n");
            }
        });

        // set the area for where the transactions will be displayed
        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Serif", Font.PLAIN, 20));
        area.setBounds(20, 150, 740, 300);
        for(Triplet triplet: users.get(currentUserPosition).getRegister()){
            area.append(triplet.toString() + "\n");
        }

        // add all components to the frame and adjusting its parameters
        {
            frame.add(icon);
            frame.add(switchTransactionSorting);
            frame.add(area);
            frame.add(switchOrder);
            frame.add(onlyDeposit);
            frame.add(onlyWithdraw);
            frame.add(both);


            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);
            frame.setVisible(true);
        }
    }

    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator){
        if(list.length > 1){
            E[] first = Arrays.copyOf(list, list.length/2);
            mergeSort(first, comparator);

            E[] second = Arrays.copyOfRange(list, list.length/2, list.length);
            mergeSort(second, comparator);

            merge(first, second, list, comparator);
        }
    }

    public static <E> void merge(E[] first, E[] second, E[] list,
                                 Comparator<? super E> comparator) {
        int f = 0, s = 0,  n = 0;

        while (f < first.length && s < second.length) {
            if (comparator.compare(first[f], second[s]) < 0)
                list[n++] = first[f++];
            else
                list[n++] = second[s++];
        }

        while (f < first.length)
            list[n++] = first[f++];

        while (s < second.length)
            list[n++] = second[s++];
    }


}
