package edu.mum.cs.cs525.labs.exercises.project.console.framework;

public class Application {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        // create 2 accounts;
        accountService.createPersonalAccount("1263862", "Frank Brown", "Hampton 3814 - 3rd ST", "www.me@gmai.com");
        accountService.createPersonalAccount("4253892", "John Doe", "Hampton 3814 - 3rd ST", "www.me@gmai.com");
        // use account 1;
        accountService.deposit("1263862", 240);

        accountService.deposit("1263862", 529);
        accountService.withdraw("1263862", 230);
        // use account 2;
        accountService.deposit("4253892", 12450);
        accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
//        // Custom Func
//        accountService.addInterest();
//        // show balances
//
        for (Account account : accountService.getAllAccounts()) {
            Customer customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountNumber());
            System.out.println("Account Holder: " + customer.getName());

            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");

            for (Transaction entry : account.getTransactionHistory()) {
                System.out.printf("%30s%30s%20.2f\n",
                        entry.getDate().toString(),
                        entry.getName(),
                        entry.getAmount());
            }

            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }
}
