package edu.mum.cs.cs525.labs.exercises.project.console.framework.template_method;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.List;

public abstract class ReportGenerator {

    public final Map<String, Object> generateReport() {
        Map<String, Object> report = new HashMap<>();
        report.put("header", header());
        report.put("body", printReport());
        report.put("footer", footer());
        return report;
    }

    protected abstract String header();
    protected abstract List<Transaction> printReport();

    protected abstract String footer();
}