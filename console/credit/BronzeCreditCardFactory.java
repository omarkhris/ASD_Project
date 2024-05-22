package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.CreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;

public class BronzeCreditCardFactory implements CreditCardFactory {
    @Override
    public CreditCard createCreditCard(String accountNumber, double balance, double minimumPaymentPercentage, Customer customer) {
        return new CreditCard(accountNumber, balance, minimumPaymentPercentage, customer, "Bronze");
    }
}
