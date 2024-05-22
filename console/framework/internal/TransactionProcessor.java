package edu.mum.cs.cs525.labs.exercises.project.console.framework.internal;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

import java.util.List;

public class TransactionProcessor {
    public void processTransaction(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            transaction.getDetails();
        }
    }
}
