package edu.mum.cs.cs525.labs.exercises.project.console.framework;

public class Saving implements AccountBehavior {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.03;
    }
}
