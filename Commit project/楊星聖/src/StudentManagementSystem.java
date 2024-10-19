package Java_class_023_Student_System_Project;

import java.util.*;

public class StudentManagementSystem {
	private List<StudentAccount> accounts = new ArrayList<StudentAccount>();
	private Map<String,StudentAccount> accountMap = new HashMap<String,StudentAccount>();
	
	//新增學生資料
	public void addStudentNumber(StudentAccount number) throws Exception {
		if(accountMap.containsKey(number.getStudentNumber())) {
			throw new Exception("Account Number: "+number.getStudentNumber()+" 此學生號碼已經存在");
		}
		accounts.add(number);
		accountMap.put(number.getStudentNumber(), number);
	}
	
	//移除學生資料
	public void removeStudentNumber(String Number) throws Exception{
		StudentAccount account = accountMap.remove(Number);
		accounts.removeIf(acc->acc.getStudentNumber().equals(Number));
		if(account==null) {
			throw new Exception("無對應學生號碼");
		}
	}
	
	//顯示所有學生基本資料
	public void displayStudentInfo() {
		for(StudentAccount acc: accounts) {
			System.out.println(acc);
		}
	}
		
	//顯示查找學生基本資料
	public void getInfoByNumber(String getnumber) throws Exception {
		StudentAccount acc = accountMap.get(getnumber);
		if(acc==null) {
			throw new Exception("查無此學生號碼");
		}
		System.out.println(acc);
	}
	
	// 顯示學生各科成績
    public void displayEachGrades(String studentNumber) throws Exception {
        StudentAccount student = accountMap.get(studentNumber);
        if (student == null) {
            throw new Exception("查無此學生號碼");
        }

        HashMap<String, Integer> grades = student.getGrades(); // 從 StudentAccount 中獲取成績
        if (grades == null || grades.isEmpty()) {
            System.out.println("無學生成績");
            return;
        }

        System.out.println("學生各科成績:");
        for (String subject : grades.keySet()) {
            System.out.println(subject + " : " + grades.get(subject));
        }
    }

    // 顯示學生總分數和平均成績
    public void displayTotalGrade(String studentNumber) throws Exception {
        StudentAccount student = accountMap.get(studentNumber);
        if (student == null) {
            throw new Exception("查無此學生號碼");
        }

        HashMap<String, Integer> grades = student.getGrades();
        if (grades == null || grades.isEmpty()) {
            System.out.println("無學生成績");
            return;
        }

        int totalSubjects = grades.size();
        double totalScore = 0;
        for (int grade : grades.values()) {
            totalScore += grade;
        }
        double averageScore = totalScore / totalSubjects;

        System.out.println("總科目: " + totalSubjects + " 總分數: " + totalScore + " 總平均成績為: " + averageScore);
    }
	

	
	public static void main(String[] args) {
		StudentManagementSystem system = new StudentManagementSystem();
		try {
			 System.out.println("1_____________________________________");
			StudentAccount account1 = new UndergraduateStudent("101", "Amy", 20, 4.0, 2, "Math");
			//account1.setGPA(5.0);
			system.addStudentNumber(account1);
            // 設置學生成績
            account1.addGrade("Math", 95);
            account1.addGrade("English", 100);
            //account1.addGrade("English", 101);
            
            //學生個人資訊
            account1.setAddress("Taichung City");
            account1.setphone("0936666666");
            account1.Personalinfo();
            
            System.out.println("2_____________________________________");
            system.getInfoByNumber("101");
            // 顯示學生成績
            system.displayEachGrades("101");;
            
            System.out.println("3_____________________________________");
            StudentAccount account2 = new GraduateStudent("102", "Nick", 25, 3.0, "Java Coding", "John");
			system.addStudentNumber(account2);
            // 設置學生成績
			account2.addGrade("Java", 80);
			account2.addGrade("SQL", 85);
			account2.updateGrade("Java", 90);
			
            // 顯示所有學生的資訊
            system.displayStudentInfo();
            System.out.println("4_____________________________________");
            // 顯示學生成績
            system.displayEachGrades("102");
            system.displayTotalGrade("102");
            system.removeStudentNumber("101");
            system.displayStudentInfo();
            System.out.println("5_____________________________________");
            system.getInfoByNumber("101");
            
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
