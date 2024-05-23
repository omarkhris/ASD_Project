package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.ReportGenerator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

import java.util.List;

public class CreditCardReportGenerator extends ReportGenerator {

    private List<Transaction> transactions;

    public CreditCardReportGenerator(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    protected void fetchData() {
        // Fetch data logic specific to credit card
    }

    @Override
    protected void formatData() {
        // Format data logic specific to credit card
    }

    @Override
    protected List<Transaction> printReport() {
        // Print report logic specific to credit card
        System.out.println("Credit Card Report");
        for (Transaction transaction : transactions) {
            transaction.getDetails();
        }

        return this.transactions;
    }
}