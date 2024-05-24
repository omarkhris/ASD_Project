package edu.mum.cs.cs525.labs.exercises.project.console.framework.internal;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;

import java.io.Serializable;

public class InterestCalculator implements Serializable {
    private static final long serialVersionUID = 1L;
    public double calculateInterest(double balance, InterestStrategy interestStrategy){
        return interestStrategy.calculateInterest(balance);
    }
}