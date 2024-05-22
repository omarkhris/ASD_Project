package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;

public interface CreditCardFactory {
    CreditCard createCreditCard(String accountNumber, double balance, double minimumPaymentPercentage, Customer customer);
}