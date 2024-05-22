package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;

public class SavingsInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.03;
    }
}