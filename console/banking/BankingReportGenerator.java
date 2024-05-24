package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.template_method.ReportGenerator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import java.util.List;

public class BankingReportGenerator extends ReportGenerator {

    private List<Transaction> transactions;
    private String accountNumber;

    public BankingReportGenerator(List<Transaction> transactions, String accountNumber) {
        this.transactions = transactions;
        this.accountNumber = accountNumber;
    }

    @Override
    protected String header() {
        return "-----GENERATOR - " + accountNumber + "-----";

    }

    @Override
    protected List<Transaction> printReport() {
        return transactions;
    }

    @Override
    protected String footer() {
        return "-----END-----";
    }
}