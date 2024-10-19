package Java_class_023_Student_System_Project;

import java.util.HashMap;

public class StudentAccount {
	
	private String studentName;
	private String studentNumber;
	private int studentAge;
	private double GPA;
	private HashMap<String, Integer> grades;
	private String address;
	private String phone;
	
	
	public StudentAccount(String studentNumber,String studentName,int studentAge,double GPA) throws Exception {
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.studentAge = studentAge;
//		if (GPA > 4.0) {
//	        throw new Exception("GPA不能超過4.0");
//	    } else if (GPA < 0.0) {
//	        throw new Exception("GPA不能小於0.0");
//	    }
//		this.GPA = GPA;
		setGPA(GPA);  // 進階用法  使用 setGPA 方法檢查 GPA 的值
		this.grades = new HashMap<>(); // 初始化
		
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double GPA) throws Exception {
		if (GPA > 4.0) {
			System.out.println(GPA);
	        throw new Exception("GPA不能超過4.0");
	    } else if (GPA < 0.0) {
	        throw new Exception("GPA不能小於0.0");
	    }
		this.GPA = GPA;
	}
	
	public HashMap<String, Integer> getGrades() {
		return grades;
	}

	public void setGrades(HashMap<String, Integer> grades) {
		this.grades = grades;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}
	
	//顯示學生基本資料
	public String toString() {
		return String.format("學生姓名: %s, 學號: %s, 年齡: %d, GPA: %.2f", 
                studentName, studentNumber, studentAge, GPA);
	}
	//顯示學生個人資料
	public void Personalinfo() {
		System.out.println("Student address: "+ address);
		System.out.println("Student phone number: "+ phone);
	}
	
	//新增學生成績
	public void addGrade(String subject, int grade) throws Exception {
	    if (grades.containsKey(subject)) {
	        throw new Exception("該科目的成績已存在，如果需要更改成績請使用 Updategrade");
	    }
	    if (grade > 100) {
	        throw new Exception("成績不能超過100分");
	    } else if (grade < 0) {
	        throw new Exception("成績不能低於0分");
	    }
	    grades.put(subject, grade);
	}
	
	//更新學生成績
	public void updateGrade(String subject, int newGrade) throws Exception {
	    // 檢查該學生是否有成績資料
	    if (grades == null) {
	        throw new Exception("無成績資料，請先使用 addGrade 新增成績");
	    }

	    // 如果該科目不存在，提示使用 addGrade 方法
	    if (!grades.containsKey(subject)) {
	        throw new Exception("該科目的成績不存在，請使用 addGrade 方法來新增資料");
	    }
	    // 更新成績
	    grades.put(subject, newGrade);
	    System.out.println("成績已更新: " + subject + " 成績為: " + newGrade);
	}
	

}
