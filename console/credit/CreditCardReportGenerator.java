package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.template_method.ReportGenerator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

import java.util.List;

public class CreditCardReportGenerator extends ReportGenerator {

    private String accountNumber;
    private List<Transaction> transactions;

    public CreditCardReportGenerator(List<Transaction> transactions, String accountNumber) {
        this.transactions = transactions;
        this.accountNumber = accountNumber;
    }

    @Override
    protected String header() {
        return "-----GENERATOR - ACCOUNT - " + accountNumber + "-----";
    }

    @Override
    protected List<Transaction> printReport() {
        return transactions;
    }

    @Override
    protected String footer() {
        return "-----END OF REPORT-----";
    }
}