package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.CreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;

public class CreditCardAccountFactory implements AccountFactory {


    @Override
    public Account createPersonalAccount(String accountNumber, double balance, Customer customer, String accountType) {
        throw new UnsupportedOperationException("Not supported for CreditCard");
    }

    @Override
    public Account createCompanyAccount(String accountNumber, double balance, Customer customer, String accountType) {
        throw new UnsupportedOperationException("Not supported for CreditCard");
    }

    @Override
    public Account createCreditCard(String type, String accountNumber, double limitBalance, double miniPaymentPercentage, Customer customer) {
        return CreditCardFactoryProvider.getFactory(type).createCreditCard(accountNumber, limitBalance, miniPaymentPercentage, customer);
    }
}
