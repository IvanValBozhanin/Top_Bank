package com.company;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;


// User class: represents the client in the system
public class User implements Serializable {

    // initialize all the fields which will be needed
    private String name;
    private String username;
    private String password;
    private double balance;
    private ArrayList<Triplet> register;

    // constructor for the User class
    public User(String name, String username, String password, double balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.balance = balance;
        register = new ArrayList<>();
    }

    // defines the operations when withdrawing
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

    // defines the operations when depositing
    public void deposit(double sum){
        register.add(new Triplet(false, new Date(), sum));
        balance += sum;
    }

    //getters for some of the fields

    public ArrayList<Triplet> getRegister() {
        return register;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    // toString function
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
