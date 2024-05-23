package edu.mum.cs.cs525.labs.exercises.project.console.framework;


import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private List<Rule> rules;

    public RuleEngine() {
        this.rules = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void applyRules(Account account) {
        for (Rule rule : rules) {
            rule.apply(account);
        }
    }
}

