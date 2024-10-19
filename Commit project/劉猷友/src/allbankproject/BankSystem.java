package allbankproject;


import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {
    private HashMap<String, BankAccount> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    
    public void createAccount() {
        System.out.print("請輸入帳戶號碼: ");
        String accountNumber = scanner.nextLine();
        System.out.print("請輸入帳戶持有者姓名: ");
        String accountHolder = scanner.nextLine();

        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new BankAccount(accountNumber, accountHolder));
            System.out.println("帳戶創建成功！");
        } else {
            System.out.println("帳戶號碼已存在！");
        }
    }

   
    public void deposit() {
        System.out.print("請輸入帳戶號碼: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("請輸入存款金額: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.deposit(amount);
        } else {
            System.out.println("找不到該帳戶！");
        }
    }

 
    public void withdraw() {
        System.out.print("請輸入帳戶號碼: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("請輸入取款金額: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.withdraw(amount);
        } else {
            System.out.println("找不到該帳戶！");
        }
    }

  
    public void checkBalance() {
        System.out.print("請輸入帳戶號碼: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.println("當前餘額: " + account.getBalance());
        } else {
            System.out.println("找不到該帳戶！");
        }
    }

 
    public void transfer() {
        System.out.print("請輸入發送帳戶號碼: ");
        String fromAccountNumber = scanner.nextLine();
        BankAccount fromAccount = accounts.get(fromAccountNumber);

        if (fromAccount != null) {
            System.out.print("請輸入接收帳戶號碼: ");
            String toAccountNumber = scanner.nextLine();
            BankAccount toAccount = accounts.get(toAccountNumber);

            if (toAccount != null) {
                System.out.print("請輸入匯款金額: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                if (amount > 0 && amount <= fromAccount.getBalance()) {
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    System.out.println("匯款成功！匯款金額: " + amount);
                } else {
                    System.out.println("匯款失敗！餘額不足或金額無效");
                }
            } else {
                System.out.println("找不到接收帳戶！");
            }
        } else {
            System.out.println("找不到發送帳戶！");
        }
    }

   
    public void start() {
        while (true) {
            System.out.println("選擇功能: 1. 創建帳戶 2. 存款 3. 取款 4. 查詢餘額 5. 匯款 6. 退出");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    System.out.println("退出系統。");
                    return;
                default:
                    System.out.println("無效選擇，請重新選擇。");
            }
        }
    }
}
