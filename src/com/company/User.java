package com.company;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;

public class User implements Serializable {
    private String name;
    private String username;
    private String password;
    private double balance;
    private ArrayList<Triplet> register;

    public User(String name, String username, String password, double balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.balance = balance;
        register = new ArrayList<>();
    }

    public void withdraw(double sum){
        try {
            if(sum <= balance){
                register.add(new Triplet(true, new Date(), sum));
                balance -= sum;
            }
            else{
                throw new InvalidParameterException();
            }
        }
        catch (InvalidParameterException e){
            System.out.println("Cannot withdraw so much money." + username);
        }
    }

    public void deposit(double sum){
        register.add(new Triplet(false, new Date(), sum));
        balance += sum;
    }

    public ArrayList<Triplet> getRegister() {
        return register;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", register=" + register +
                '}';
    }
}
