package java_project2;

import java.util.*;

public class ManagementSystem<StudentAccount> {
	private List<Student> accounts = new ArrayList<>();
	private Map<String, Student> studentMap = new HashMap<>();

	public void addStudent(Student account) throws Exception {
		if (studentMap.containsKey(account.getName())) {
			throw new Exception(account.getName() + "already exist!");
		}
		accounts.add(account);
		studentMap.put(account.getName(), account);
	}

	public void removeStudent(String id) throws Exception {
		Student account = studentMap.remove(id);
		if (account == null) {
			throw new Exception("無對應帳戶!");

		}

		accounts.remove(account);
	}

	public void displayStudent() {
		for (Student account : accounts) {
			System.out.println(account);
		}
	}

	public Student getID(String getID) throws Exception {
		Student account = studentMap.get(getID);
		if (account == null) {
			throw new Exception("無對應帳戶!");
		}
		return account;

	}

	public static void main(String[] args) {
		ManagementSystem<?> system = new ManagementSystem<>();
		try {
			Student account1 = new ExtendsStudent("Aphra", "A123", 10, 80, "AI");
			Student account2 = new MasterStudent("Beta", "B321", 12, 59, "ZZZ", "ET");
			system.addStudent(account1);
			system.addStudent(account2);
			system.displayStudent();
			System.out.println(system.getID("Aphra"));
			account1.Identity();
			system.addStudent(account2);
			system.removeStudent("c546");
			system.displayStudent();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
