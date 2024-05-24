package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;

import java.util.List;
import java.util.stream.Collectors;

public class FraudAlertRule implements Rule{
    @Override
    public void apply(Account account) {
        if (account instanceof CreditCard) {
            List<Transaction> withdrawals = account.getTransactionHistory().stream()
                    .filter(t -> t.getName().equalsIgnoreCase("withdraw"))
                    .collect(Collectors.toList());

            for (int i = 0; i < withdrawals.size(); i++) {
                double averageAmount = withdrawals.subList(0, i).stream()
                        .mapToDouble(Transaction::getAmount)
                        .average()
                        .orElse(0);

                if (withdrawals.get(i).getAmount() > 2 * averageAmount) {
                    System.out.println(account.getCustomer().getEmail() + " : Fraud Alert" + "A charge of $" + withdrawals.get(i).getAmount() + " is detected as potentially fraudulent.");
                }
            }
        }
    }
}