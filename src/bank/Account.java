/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author ADMIN
 */
public class Account {

    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", id=" + accountHolder + ", balance=" + balance + '}';
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double accountHolder) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public Account() {
    }

    public Account(long accountNumber, Customer accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    private long accountNumber;
    private Customer accountHolder;
    private double balance;
    
    
    public boolean depositing(double depositingAmount){
        balance+=depositingAmount;
        return true;
    }
    public boolean withdrawing(double withdrawingAmount){
        if(withdrawingAmount>balance){
            balance-=withdrawingAmount;
            return true;
        }
             return false;
    }
}
