/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.atmca2;

import java.io.*;

/**
 *
 * @author Alwin Singh DIT FT/1B/01 P1935996
 */
public class BankAccount implements Serializable {

    private double balance;
    private int number, password; // Number defines account number and password defines account's pin
    private String acctype, name;

    //Default constructor needed as there is an overloaded constructor
    public BankAccount() {
    }

    //Overloaded constructor
    public BankAccount(int number, int password, double balance, String acctype, String name) {
        this.number = number;
        this.balance = balance;
        this.password = password;
        this.acctype = acctype;
        this.name = name;
    }

    public void setBalance(double newBalance) {
        //Since balance is a private variable, set method is used to alter the variable
        balance = newBalance; // Sets class double variable balance to the new passed variable 'newBalance'
    }

    public double getBalance() {
        //Since balance is a private variable, get method is used to get the variable's value
        return balance;
    }

    public int getAcctNumber() {
        //Since number is a private variable, get method is used to get the variable's value
        return number;
    }

    public void setPassword(int newpass) {
        //Since password is a private variable, get method is used to get the variable's value
        password = newpass; // Sets class double variable password to the new passed variable 'newpass'
    }

    public int getAcctPass() {
        return password;
    }

    public String getAcctType() {
        return this.acctype;
    }

    public String getAcctHolderName() {
        return this.name;
    }

}
