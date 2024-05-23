package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.List;

public abstract class ReportGenerator {

    public final void generateReport() {
        fetchData();
        formatData();
        printReport();
    }

    protected abstract void fetchData();
    protected abstract void formatData();
    protected abstract List<Transaction> printReport();
}