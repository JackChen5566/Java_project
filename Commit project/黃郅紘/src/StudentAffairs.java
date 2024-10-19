package Java_course_Project2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAffairs extends Student {
	private double AvgGPA;
	Scanner scanner = new Scanner(System.in);
	public double getAvgGPA() {
		return AvgGPA;
	}

	public void setAvgGPA(double avgGPA) {
		AvgGPA = avgGPA;
	}

	public StudentAffairs(String name, String ID, int credits) {
		super(name, ID, credits);
		// TODO Auto-generated constructor stub
	}

	public void graduated_course(String name, String ID, int credits) throws Exception {
		char id = ID.charAt(0);
		int requiredcourse = 0;
		int electivecourse = 0;
		boolean a = false;
		if(id=='B'&&requiredcourse>=84&&electivecourse>=36) {
			System.out.println("已達到大學部畢業門檻");
			a=true;
		}
		if(id=='M'&&requiredcourse>=25&&electivecourse>=15) {
			System.out.println("已達到碩士班畢業門檻");
			a=true;
		}
		else if (a==false&&id=='B'){
			if(requiredcourse<=84) {
			System.out.printf("必修學分未達畢業門檻, 還須%d學分",(84-requiredcourse));
			}
			if(electivecourse<=36) {
				System.out.printf("選修學分未達畢業門檻, 還須%d學分",(36-electivecourse));
			}
			System.out.printf("總共還需%d學分", (120-requiredcourse-electivecourse));
		}
		else {
			throw new Exception();
		}
	}
	
	public void Transcripts() throws Exception {
		String a = null;
		double sum=0;
		int count =0;
		for(;;) {
		if(a!="END") {
			count++;
			System.out.println("Please input your GPA");
			double b = scanner.nextDouble();
			sum +=b;
		}
		else if (a=="END") {
			break;
		}
	}
		this.AvgGPA = sum/count;
		System.out.println("平均成績 : " + getAvgGPA());
	}
	
	public void Enrollment() throws Exception {
		char id = getID().charAt(0);
		super.Enrollment(getName(), getID());
		if(id=='B'&&getAvgGPA()>=3.7) {
			System.out.println("符合大學部雙主修資格");
		}
		if(getAvgGPA()<=2.0) {
			System.out.println("本學期二一");
		}
		else {
			throw new Exception();
		}
		
		
	}
	
	public String toString() {
	    return "Name: " + getName() + ", ID: " + getID() + ", Credits: " + getCredits();
	}
	
	
	
}
