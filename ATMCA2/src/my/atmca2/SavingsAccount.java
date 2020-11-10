/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.atmca2;

/**
 *
 * @author Alwin Singh
 */
public class SavingsAccount extends BankAccount {

    public SavingsAccount() {

    }

    public SavingsAccount(int number, int password, double balance, String acctype, String name) {
        super(number, password, balance, acctype, name);
    }

    public double interestRate(double balance2) {
        double newbalance = balance2 * 1;
        return newbalance;
    }
}
