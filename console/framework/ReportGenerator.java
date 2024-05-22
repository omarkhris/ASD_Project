package edu.mum.cs.cs525.labs.exercises.project.console.framework;

public abstract class ReportGenerator {

    public final void generateReport() {
        fetchData();
        formatData();
        printReport();
    }

    protected abstract void fetchData();
    protected abstract void formatData();
    protected abstract void printReport();
}