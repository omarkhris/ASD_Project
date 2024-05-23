package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.ReportGenerator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import java.util.List;

public class BankingReportGenerator extends ReportGenerator {

    private List<Transaction> transactions;

    public BankingReportGenerator(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    protected void fetchData() {
        // Fetch data logic specific to banking

    }

    @Override
    protected void formatData() {
        // Format data logic specific to banking
    }

    @Override
    protected List<Transaction> printReport() {
        // Print report logic specific to banking
//        System.out.println("Banking Report " + transactions.size());
//
//        for (Transaction transaction : transactions) {
//            transaction.getDetails();
//        }

        return this.transactions;
    }
}