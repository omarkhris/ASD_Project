package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;

public class BronzeInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.10;
    }
}