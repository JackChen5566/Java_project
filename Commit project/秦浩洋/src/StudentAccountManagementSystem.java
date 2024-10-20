package Java_class_peoject_03;

import java.util.*;

import Java_class_peoject_02.BankAccount;
import Java_class_peoject_02.BankAccountManagementSystem;
import Java_class_peoject_02.CheckingAccount;
import Java_class_peoject_02.SavingsAccount;

public class StudentAccountManagementSystem {

	private List<StudentAccount> accounts = new ArrayList<>();
	private Map<String, StudentAccount> accountMap = new HashMap<>();

	public void addAccount(StudentAccount account) throws Exception {
		if (accountMap.containsKey(account.getSID())) {
			throw new Exception(account.getSID() + "錯誤：ID 已存在！");
		}
		accounts.add(account);
		accountMap.put(account.getSID(), account);

	}

	public void removeAccount(String SID) throws Exception {
		StudentAccount account = accountMap.remove(SID);
		if (account == null) {
			throw new Exception("無對應學生ID!");
		}

		accounts.remove(account);
	}

	public void displayAccounts() {
		for (StudentAccount account : accounts) {
			System.out.println(account);
		}
	}

	public StudentAccount getAccountByNumber(String getSID) throws Exception {

		StudentAccount account = accountMap.get(getSID);
		if (account == null) {
			throw new Exception("無對應學生ID!");
		}
		return account;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentAccountManagementSystem system = new StudentAccountManagementSystem();
		try {
			StudentAccount account1 = new bachelorAccount("Andy","100",18, 100.0 ,0.5,"數學");
			StudentAccount account2 = new masterAccount("Bod","99",25, 60.0 ,0.1,"數學");
			
			system.addAccount(account1);
			system.addAccount(account2);
			
			system.displayAccounts();
			System.out.println(system.getAccountByNumber("101"));
			System.out.println(system.getAccountByNumber("100"));
			System.out.println(system.getAccountByNumber("99"));
			system.removeAccount("121");
			//System.out.println(system.getAccountByNumber("101"));
			
			system.displayAccounts();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
