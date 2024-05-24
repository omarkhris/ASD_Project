package edu.mum.cs.cs525.labs.exercises.project.console.framework.observer;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

public interface Observer {
    void update(Transaction transaction);
}