package edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.MinimumPaymentStrategy;

import java.io.Serializable;

public class BronzeMinimumPaymentStrategy implements MinimumPaymentStrategy, Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    public double calculateMinimumPayment(double lineOfCredit, double balance) {
        return (lineOfCredit - balance) * 0.14;
    }
}