package com.company;

import java.io.Serializable;
import java.util.Date;


// Triplet class: represents some of the data which the User has
public class Triplet implements Serializable {

    // initialize all of the fields
    private final boolean isWithdraw;
    private final Date date;
    private final double sum;

    // create main constructor of the class
    public Triplet(boolean isWithdraw, Date date, double sum) {
        this.isWithdraw = isWithdraw;
        this.date = date;
        this.sum = sum;
    }

    // getters of the class's fields

    public boolean isWithdraw() {
        return isWithdraw;
    }

    public Date getDate() {
        return date;
    }

    public double getSum() {
        return sum;
    }

    // toString function
    @Override
    public String toString() {
        return String.format("%s \t $%.2f \t %tc", isWithdraw ? "Withdraw" : "Deposit",
                sum, date);
    }
}
