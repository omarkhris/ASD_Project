package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;

import java.util.Date;
import java.util.HashMap;

public class CreditCard extends Account {
    private MinimumPaymentStrategy minimumPaymentStrategy;
    private InterestStrategy interestStrategy;
    private final double lineOfCredit;


    public CreditCard(String accountNumber, double lineOfCredit, Customer customer, String accountType, HashMap<String, Object> additionalInfo) {
        super(accountNumber, lineOfCredit, accountType, customer, additionalInfo);
        this.lineOfCredit = lineOfCredit;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public void deposit(double amount) {
        updateBalance(- amount);  // Depositing reduces credit card balance (paying off)
        transactions.add(new Transaction(new Date(), "Deposit", amount));
        notify(new Transaction(new Date(), "Deposit", amount));
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdraw operation is not supported for Credit Card");
    }

    @Override
    public void addInterest() {
        double interest = interestStrategy.calculateInterest(balance);
        updateBalance(- interest);
        transactions.add(new Transaction(new Date(), "Interest", interest));
        notify(new Transaction(new Date(), "Interest", interest));
    }

    public void charge(double amount) {
        if (balance > amount) {
            updateBalance(+ amount);

            if (amount > 400) {
                customer.update(new Transaction(new Date(), "Large Charge", amount));
            }
        }

        customer.update(new Transaction(new Date(), "Charge", amount));
        notify(new Transaction(new Date(), "Charge", amount));
    }

    @Override
    public void generateReport() {
        new CreditCardReportGenerator(transactions).generateReport();
    }

    public double getLineOfCredit() {
        return lineOfCredit;
    }

    public double calculateMinimumPayment() {
        return minimumPaymentStrategy.calculateMinimumPayment(lineOfCredit, balance);
    }

    public void setMinimumPaymentStrategy(MinimumPaymentStrategy minimumPaymentStrategy) {
        this.minimumPaymentStrategy = minimumPaymentStrategy;
    }

    public void setInterestStrategy(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    public void generateMonthlyBillingReport() {
        double previousBalance = balance;
        double totalCharges = transactions.stream().filter(t -> t.getName().equals("Charge")).mapToDouble(Transaction::getAmount).sum();
        double totalCredits = transactions.stream().filter(t -> t.getName().equals("Payment")).mapToDouble(Transaction::getAmount).sum();
        double newBalance = previousBalance - totalCredits + totalCharges + interestStrategy.calculateInterest(previousBalance - totalCredits);
        double totalDue = 0 * newBalance; // Todo: minimumPaymentPercentage is not defined
        System.out.println("Monthly Billing Report");
        System.out.println("----------------------");
        System.out.println("Previous Balance: " + previousBalance);
        System.out.println("Total Charges: " + totalCharges);
        System.out.println("Total Credits: " + totalCredits);
        System.out.println("New Balance: " + newBalance);
        System.out.println("Total Due: " + totalDue);
    }
}