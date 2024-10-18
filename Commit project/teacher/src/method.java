package project01;

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

    @Override
    public String toString() {
        return "Savings " + super.toString() + ", Interest Rate=" + interestRate + "%";
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > 0 && amount <= (getBalance() + overdraftLimit)) {
            super.withdraw(amount);
        } else {
            throw new Exception("Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public String toString() {
        return "Checking " + super.toString() + ", Overdraft Limit=" + overdraftLimit;
    }
}
