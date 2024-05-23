package edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;

import java.io.Serializable;

public class BronzeInterestStrategy implements InterestStrategy, Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.10;
    }
}