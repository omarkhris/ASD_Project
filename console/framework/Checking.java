package edu.mum.cs.cs525.labs.exercises.project.console.framework;

public class Checking implements AccountBehavior {
    @Override
    public double calculateInterest(double balance) {
        if (balance < 1000) return balance * 0.015;
        else return balance * 0.025;
    }
}
