package Java_course_Project2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Java_course_Project1.BankAccount;

public class Student_Management_System {
	List<Student> students = new ArrayList<>();
	Map<String, Student> studentMap = new HashMap<>();
public void addStudents(Student student) throws Exception {
	if(studentMap.containsKey(student.getID())) {
		throw new Exception();
	}
	students.add(student);
	studentMap.put(student.getID(), student);
	
}
public void removestudents(Student ID) throws Exception {
	Student student = studentMap.remove(ID);
	if(student==null) {
		throw new Exception("無對應學生資料");
	}
}
public void DisplayInfo() {
	for(Student student : students) {
		System.out.println(student.toString());
	}
}
public Student getInfoByID(String getID) throws Exception {
	
	Student students = studentMap.get(getID);
	if (students == null) {
		throw new Exception("無此學生資訊");
	}
	return students;
}
	public static void main(String[] args) throws Exception {
		Student_Management_System s = new Student_Management_System();
		Student s1 = new StudentAffairs("Steven", "B101",24);
		Student s2 = new StudentAffairs("Bob", "M101", 10);
		s.addStudents(s1);
		s.addStudents(s2);
		s.DisplayInfo();
		System.out.println(s.getInfoByID("B101"));
		s1.Enrollment("Steven", "B101");
		
		
		
	}
	

}
