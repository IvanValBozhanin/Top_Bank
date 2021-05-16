package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
//        test();
        new StartPanel();
        new NewUser();
        new UserHomePage();
        new DepositPanel();
        new WithdrawPanel();
        new HistoryTransactions();
    }

    public static void test() throws IOException{
        User user = new User("Peter", "p11", "bbbb", 100);
        User user1 = new User("Ivan", "sss", "aaaa", 200);
        User user2 = new User("Georgi", "aaa", "fzzzz", 300);

        user.deposit(200);
        user.withdraw(300);

        user1.withdraw(100);

        user2.withdraw(4000);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src.dat"))){
            out.writeObject(user);
            out.writeObject(user1);
            out.writeObject(user2);
        }

        ArrayList<User> users = new ArrayList<>();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("src.dat"))){
            try{
                for(;;){
                    User u = (User) in.readObject();
                    users.add(u);
                }
            }
            catch (EOFException eofException){
                System.out.println("===read all===");
            }
            catch (ClassNotFoundException e) {

            }
        }

        users.get(1).withdraw(20);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src.dat"))){
            for (User value : users) {
                out.writeObject(value);
            }
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("src.dat"))){
            try{
                for(;;){
                    User u = (User) in.readObject();
                    System.out.println(u.toString());
                }
            }
            catch (EOFException eofException){
                System.out.println("===read all===");
            }
            catch (ClassNotFoundException e) {

            }
        }
    }
}
