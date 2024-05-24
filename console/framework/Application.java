package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.DTO.BankDTO;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.DTO.CardDTO;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.model.Address;

public class Application {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        // create 2 accounts;
        Address address = new Address("3814 - 3rd ST", "Hampton", "234423", "Chicago");

        BankDTO bankDTO = new BankDTO("1263862","Frank Brown", address, "Ch", "www.me@gmai.com", "Personal", 500, "May.16", "23");
        Account a = accountService.createBankingAccount(bankDTO);
        BankDTO bankDTO2 = new BankDTO("1263861","Frank Brown", address, "S", "www.me@gmai.com", "Company", 500, "May.16", "23");
        Account acc = accountService.createBankingAccount(bankDTO);

        for(Account account : accountService.getAllAccounts()) {
            System.out.println(account.getCustomer().getName());
        }

//        accountService.createPersonalAccount("1263862", "Frank Brown", "Hampton 3814 - 3rd ST", "www.me@gmai.com");
//        accountService.createPersonalAccount("4253892", "John Doe", "Hampton 3814 - 3rd ST", "www.me@gmai.com");
        // use account 1;
        accountService.deposit("1263862", 240);

        accountService.deposit("1263862", 529);
        accountService.withdraw("1263862", 230);
        a.generateReport();
        accountService.generateAddInterests(new Customer("Frank Brown",new Address("3443","3443","434","3434"),"434343"));
        a.generateReport();
        System.out.println(a.getBalance());
        System.out.println("**************************************");
        System.out.println(acc.getBalance());
        // use account 2;
        CardDTO creditDTO = new CardDTO("Frank Brown", address, 300, "Silver", "20.05.1942", "4253892", "www.me@gmai.com");
        Account a2 = accountService.createCreditAccount(creditDTO);

        accountService.deposit("4253892", 12450);
//        accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
//        // Custom Func
        a2.addInterest();

//        // show balances
        a2.generateReport();
//
//        for (Account account : accountService.getAllAccounts()) {
//            Customer customer = account.getCustomer();
//            System.out.println("Statement for Account: " + account.getAccountNumber());
//            System.out.println("Account Holder: " + customer.getName());
//
//            System.out.println("-Date-------------------------"
//                    + "-Description------------------"
//                    + "-Amount-------------");
//
//            for (Transaction entry : account.getTransactionHistory()) {
//                System.out.printf("%30s%30s%20.2f\n",
//                        entry.getDate().toString(),
//                        entry.getName(),
//                        entry.getAmount());
//            }
//
//            System.out.println("----------------------------------------" + "----------------------------------------");
//            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
//        }
    }

}
