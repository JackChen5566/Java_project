package Java_class_project2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentManagement {
	
	private List<StudentAccount> studentAccounts =  new ArrayList<>();
	private Map<String, StudentAccount> accountMap = new HashMap<>();
	
	public void addAccount(StudentAccount number) throws Exception {
		if (accountMap.containsKey(number.getStudentNumber())) {
			throw new Exception(number.getStudentNumber()+"already exist!");
		}
		studentAccounts.add(number);
		accountMap.put(number.getStudentNumber(), number);
	}
	
	public void removeAccount(String accountNumber) throws Exception {
		StudentAccount account = accountMap.remove(accountNumber);
		studentAccounts.removeIf(acc->acc.getStudentNumber().equals(accountNumber));
		if (account == null) {
			throw new Exception("無對應學號");
		}
		//studentAccounts.remove(account);
	}
	public void displayAccounts() {
		for(StudentAccount account:studentAccounts) {
			System.out.println(account);
		}
	}
    
    public StudentAccount getAccountByNumber(String getAccountNumber) throws Exception {
    	
    	StudentAccount account = accountMap.get(getAccountNumber);
		if(account == null) {
			throw new Exception("無對應帳戶!");
		}
		return account;
	}
    
	public static void main(String[] args) {
		StudentManagement system = new StudentManagement();
		try {
			StudentAccount account1 = new GraduateStudent("100","Andy",24,"Industry","Kevin");
			StudentAccount account2 = new CollegeStudent("101","Mary",20,"Management","2");
			system.addAccount(account1);
			system.addAccount(account2);
			account1.addGrade("Math", 80.0);
			account2.addGrade("Math", 90.0);
			system.displayAccounts();
			System.out.println(system.getAccountByNumber("100"));
			account1.displayStudent();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
