package Java_class_project2;

import java.util.HashMap;

public class StudentAccount {

	private String studentNumber;
	private String studentName;
	private int studentAge;
	private HashMap<String, Double>studentGrade ;
	
	public StudentAccount(String studentNumber, String studentName, int studentAge) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	
	public String toString() {
		return "Student Name: " + studentName + ", Student Number: " + studentNumber + ", Student Age: " + studentAge;
	}
	
	public void addGrade(String test, Double Grade) {
		if (studentGrade==null) {
			studentGrade = new HashMap<>();
		}
		if (Grade>=0 && Grade<=100) {
			studentGrade.put(test, Grade);
		}
		else {
			System.out.println("無效成績");
		}
	}
	
	public void displayStudent() {
		if (studentGrade == null || studentGrade.isEmpty()) {
			System.out.println("尚無成績");
		}
		else {
			System.out.println(studentName+"成績：");
			for (String test : studentGrade.keySet()) {
			    Double grade = studentGrade.get(test);
			    System.out.println("Test: " + test + ", Grade: " + grade);
			}
		}
	}
	
	
}
