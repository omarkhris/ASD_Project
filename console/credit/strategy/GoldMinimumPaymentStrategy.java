package edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.MinimumPaymentStrategy;

public class GoldMinimumPaymentStrategy implements MinimumPaymentStrategy {
    @Override
    public double calculateMinimumPayment(double lineOfCredit, double balance) {
        return (lineOfCredit - balance) * 0.10;
    }
}
