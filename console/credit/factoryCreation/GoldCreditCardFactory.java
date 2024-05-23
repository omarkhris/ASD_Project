package edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy.GoldInterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy.GoldMinimumPaymentStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.FactoryAccount;

import java.util.HashMap;

public class GoldCreditCardFactory implements FactoryAccount {
    @Override
    public Account createAccount(String accountNumber, double lineOfCredit, String accountType, Customer customer, HashMap<String, Object> additionalInfo) {
        CreditCard creditCard = new CreditCard(accountNumber, lineOfCredit, customer, "Gold", additionalInfo);
        creditCard.setInterestStrategy(new GoldInterestStrategy());
        creditCard.setMinimumPaymentStrategy(new GoldMinimumPaymentStrategy());
        return creditCard;
    }
}
