package allbankproject;


public class BankAccount {
    private String accountNumber;  
    private String accountHolder;   
    private double balance;          

   
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

 
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount; 
            System.out.println(String.format("存款成功！當前餘額: %.2f", balance));
            return true;
        } else {
            System.out.println("存款金額必須大於0");
            return false;
        }
    }

   
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;  
            System.out.println(String.format("取款成功！當前餘額: %.2f", balance));
            return true;
        } else {
            System.out.println("取款失敗！餘額不足或金額無效");
            return false;
        }
    }

   
    public double getBalance() {
        return balance;
    }

    
    public String getAccountHolder() {
        return accountHolder;
    }

   
    public String getAccountNumber() {
        return accountNumber;
    }
}
