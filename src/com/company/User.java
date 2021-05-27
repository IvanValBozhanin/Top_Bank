package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;


// User class: represents the client in the system
public class User implements Serializable {

    public static ArrayList<User> users = new ArrayList<>();
    public static int currentUserPosition;

    // initialize all the fields which will be needed
    private String name, username, password;
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

    public static void updateUsers() throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src.dat"))){
            for(User user: users){
                out.writeObject(user);
            }
        }
    }

    // defines the operations when withdrawing
    public void withdraw(double sum){
        if(sum <= balance){
            register.add(new Triplet(true, new Date(), sum));
            balance -= sum;
        } else {
            throw new InvalidParameterException();
        }
    }

    // defines the operations when depositing
    public void deposit(double sum){
        register.add(new Triplet(false, new Date(), sum));
        balance += sum;
    }

    //getters for the field variables

    public ArrayList<Triplet> getRegister() {
        return register;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
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
