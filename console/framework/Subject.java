package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notify(Transaction transaction) {
        for (Observer observer : observers) {
            observer.update(transaction);
        }
    }
}