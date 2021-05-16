package com.company;

import java.io.Serializable;
import java.util.Date;

public class Triplet implements Serializable {
    private boolean isWithdraw;
    private Date date;
    private double sum;

    public Triplet(boolean isWithdraw, Date date, double sum) {
        this.isWithdraw = isWithdraw;
        this.date = date;
        this.sum = sum;
    }

    public boolean isWithdraw() {
        return isWithdraw;
    }

    public Date getDate() {
        return date;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "isWithdraw=" + isWithdraw +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }
}
