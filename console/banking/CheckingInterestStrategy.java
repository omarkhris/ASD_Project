package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;

public class CheckingInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        if (balance < 1000) return balance * 0.015;
        else return balance * 0.025;
    }
}