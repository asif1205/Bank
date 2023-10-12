/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bank {

    private List<Customer> customerList;
    private List<Account> accountList;

    public Bank() {
        customerList = new ArrayList<>();
        accountList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public Account createAccount(Customer customer, double balance) {
        int accountNumber = accountList.size() + 1;
        Account account = new Account(accountNumber, customer, balance);
        accountList.add(account);
        return account;
    }

    public Customer findCustomer(int coustomerId) {
        if(customerList.size()==0){
            System.out.println("There is not any customer please add customer first");
        }
        for (Customer x : customerList) {
            if (x.getId() == coustomerId) {
                return x;
            }
        }
        return null;
    }

    public Account findAccount(long customerAccount) {
        if(accountList.size()==0){
            System.out.println("There is not any Account please create Account first");
        }
        for (Account acc : accountList) {
            System.out.println(acc.toString());
            if (acc.getAccountNumber() == customerAccount) {
                return acc;
            }
        }
        return null;
    }

    public String performTransaction(long accountNumber, double amount, String transactionType) {
        Account account = findAccount(accountNumber);
        if (account == null) {
            return "Account not fond please give me valid account number";
        }
        if (transactionType.equals("deposit")) {
            if (account.depositing(amount)) {
                return amount + " is deposited";
            } else {
                return "Please try after some time";
            }
        } else if (transactionType.equals("withdraw")) {
            if (account.withdrawing(amount)) {
                return amount + " is withdraw";
            } else {
                return "Insufficient balance";
            }
        }
        return "Please give valid transation type";
    }

    public String displayAccountDetails(long accountNumber) {
        System.out.println("called find account");
        Account account = findAccount(accountNumber);
        if (account == null) {
            return "Account not found please give me valid account number";
        }
        return account.toString();
    }

    public static void main(String args[]) {
        System.out.println("========================Welcome in my Bank==============================");
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank System Menu:");
            System.out.println("1. Add a customer");
            System.out.println("2. Create an account for a customer");
            System.out.println("3. Perform a transaction");
            System.out.println("4. Display account details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer contact information:(Mobile) ");
                    long contactInfo = scanner.nextLong();
                    Customer customer = new Customer(customerId, customerName, contactInfo);
                    bank.addCustomer(customer);
                    System.out.println("Customer added: " + customer);
                    break;

                case 2:
                    System.out.print("Enter customer ID: ");
                    int accountId = scanner.nextInt();
                    Customer accountCustomer = bank.findCustomer(accountId);
                    if (accountCustomer != null) {
                        System.out.print("Enter initial account balance: ");
                        double initialBalance = scanner.nextDouble();
                        Account account = bank.createAccount(accountCustomer, initialBalance);
                        System.out.println("Account created: " + account);
                    } else {
                        System.out.println("Customer not found. Please add the customer first.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Enter transaction amount: ");
                    double transactionAmount = scanner.nextDouble();
                    scanner.next();
                    System.out.print("Enter transaction type (deposit/withdraw): ");
                    String transactionType = scanner.nextLine();
                    String transactionResult = bank.performTransaction(accountNumber, transactionAmount, transactionType);
                    System.out.println(transactionResult);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int displayAccountNumber = scanner.nextInt();
                    String accountDetails = bank.displayAccountDetails(displayAccountNumber);
                    System.out.println("Account Details:\n" + accountDetails);
                    break;

                case 5:
                    System.out.println("Exiting the Bank System.");
                    System.out.println("Tank your for using me please come next time");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

    }
}
