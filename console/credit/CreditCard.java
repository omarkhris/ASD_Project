package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditCard extends Account {
    private double minimumPaymentPercentage;

    public CreditCard(String accountNumber, double balance, double minimumPaymentPercentage, Customer customer, String accountType) {
        super(accountNumber, balance, accountType);
        super.customer = customer;
        this.minimumPaymentPercentage = minimumPaymentPercentage;
    }

    @Override
    public void deposit(double amount) {
        balance -= amount;  // Depositing reduces credit card balance (paying off)
        transactions.add(new Transaction(new Date(), "Payment", amount));
        notify(new Transaction(new Date(), "Payment", amount));
    }

    //i used the withdraw method to charge the credit card
    @Override
    public void withdraw(double amount) {
        balance += amount;  // Charging increases credit card balance
        transactions.add(new Transaction(new Date(), "withdraw", amount));
        if (amount > 400) {
            customer.update(new Transaction(new Date(), "Large Charge", amount));
        }
        notify(new Transaction(new Date(), "Charge", amount));
    }

//    public void charge(double amount) {
//        balance += amount;  // Charging increases credit card balance
//        transactions.add(new Transaction(new Date(), "Charge", amount));
//        if (amount > 400) {
//            customer.update(new Transaction(new Date(), "Large Charge", amount));
//        }
//        notify(new Transaction(new Date(), "Charge", amount));
//    }

    @Override
    public void generateReport() {
        new CreditCardReportGenerator(transactions).generateReport();
    }

    public void generateMonthlyBillingReport() {
        double previousBalance = balance;
        double totalCharges = transactions.stream().filter(t -> t.getName().equals("Charge")).mapToDouble(Transaction::getAmount).sum();
        double totalCredits = transactions.stream().filter(t -> t.getName().equals("Payment")).mapToDouble(Transaction::getAmount).sum();
        double newBalance = previousBalance - totalCredits + totalCharges + interestStrategy.calculateInterest(previousBalance - totalCredits);
        double totalDue = minimumPaymentPercentage * newBalance;
        System.out.println("Monthly Billing Report");
        System.out.println("----------------------");
        System.out.println("Previous Balance: " + previousBalance);
        System.out.println("Total Charges: " + totalCharges);
        System.out.println("Total Credits: " + totalCredits);
        System.out.println("New Balance: " + newBalance);
        System.out.println("Total Due: " + totalDue);
    }
}