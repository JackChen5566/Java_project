package project01;

import java.util.*;

public class BankAccountManagementSystem {
    private List<BankAccount> accounts = new ArrayList<>();
    private Map<String, BankAccount> accountMap = new HashMap<>();

    public void addAccount(BankAccount account) throws Exception {
        if (accountMap.containsKey(account.getAccountNumber())) {
            throw new Exception("Account with Number " + account.getAccountNumber() + " already exists.");
        }
        accounts.add(account);
        accountMap.put(account.getAccountNumber(), account);
    }

    public void removeAccount(String accountNumber) throws Exception {
        BankAccount account = accountMap.remove(accountNumber);
        if (account == null) {
            throw new Exception("No account found with Number " + accountNumber);
        }
        accounts.remove(account);
    }

    public BankAccount getAccountByNumber(String accountNumber) throws Exception {
        BankAccount account = accountMap.get(accountNumber);
        if (account == null) {
            throw new Exception("No account found with Number " + accountNumber);
        }
        return account;
    }

    public void displayAllAccounts() {
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }

    public static void main(String[] args) {
        BankAccountManagementSystem system = new BankAccountManagementSystem();
        try {
            BankAccount account1 = new SavingsAccount("001", "Alice", 5000, 2.5);
            BankAccount account2 = new CheckingAccount("002", "Bob", 3000, 1000);

            system.addAccount(account1);
            system.addAccount(account2);

            system.displayAllAccounts();

            System.out.println("Retrieving Account with Number 001: " + system.getAccountByNumber("001"));

            account1.deposit(500);
            account1.withdraw(1000);

            system.removeAccount("001");
            system.displayAllAccounts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
