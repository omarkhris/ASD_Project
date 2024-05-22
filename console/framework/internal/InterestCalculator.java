package edu.mum.cs.cs525.labs.exercises.project.console.framework.internal;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;

public class InterestCalculator {
    public double calculateInterest(double balance, InterestStrategy interestStrategy){
        return interestStrategy.calculateInterest(balance);
    }
}
