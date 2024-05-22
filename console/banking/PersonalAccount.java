package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;

import java.util.Date;

public class PersonalAccount extends Account {

    public PersonalAccount(String accountNumber, double balance, Customer customer, String accountType) {
        super(accountNumber, balance, accountType);
        super.customer = customer;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(new Date(), "Deposit", amount));
        if (amount > 500) {
            customer.update(new Transaction(new Date(), "Large Deposit", amount));
        }
        notify(new Transaction(new Date(), "Deposit", amount));
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(new Date(), "Withdraw", amount));
            if (amount > 500 || balance < 0) {
                customer.update(new Transaction(new Date(), "Large Withdrawal or Overdraft", amount));
            }
            notify(new Transaction(new Date(), "Withdraw", amount));
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void generateReport() {
        new BankingReportGenerator(transactions).generateReport();
    }

    public void generateMonthlyBillingReport(InterestStrategy interestStrategy) {
        if (!transactions.isEmpty()) {
            double previousBalance = balance;
            double totalCharges = transactions.stream().filter(t -> t.getName().equalsIgnoreCase("Withdraw")).mapToDouble(Transaction::getAmount).sum();
            double totalCredits = transactions.stream().filter(t -> t.getName().equals("Deposit")).mapToDouble(Transaction::getAmount).sum();
            double newBalance = previousBalance - totalCredits + totalCharges + interestStrategy.calculateInterest(previousBalance - totalCredits);
            System.out.println("Monthly Billing Report");
            System.out.println("----------------------");
            System.out.println("Previous Balance: " + previousBalance);
            System.out.println("Total Charges: " + totalCharges);
            System.out.println("Total Credits: " + totalCredits);
            System.out.println("New Balance: " + newBalance);
        }
    }
}