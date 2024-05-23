package edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy.BronzeInterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy.BronzeMinimumPaymentStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.FactoryAccount;

import java.util.HashMap;

public class BronzeCreditCardFactory implements FactoryAccount {
    @Override
    public Account createAccount(String accountNumber, double lineOfCredit, String accountType, Customer customer, HashMap<String, Object> additionalInfo) {
        CreditCard creditCard = new CreditCard(accountNumber, lineOfCredit, customer, "Bronze", additionalInfo);
        creditCard.setInterestStrategy(new BronzeInterestStrategy());
        creditCard.setMinimumPaymentStrategy(new BronzeMinimumPaymentStrategy());
        return creditCard;
    }
}
