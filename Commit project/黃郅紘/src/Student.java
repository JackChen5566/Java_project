package Java_course_Project2;

public class Student {
	private String name;
	private String ID;
	private int credits ;
	private double GPA;
	public String course;
	public Student(String name, String ID, int credits) {
		this.name = name;
		this.ID = ID;
		this.credits = credits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double GPA) {
		this.GPA = GPA;
	}
	
	public void Enrollment(String name, String ID) throws Exception {
		this.name = name;
		this.ID = ID;
		char id = ID.charAt(0);
		if(id=='B') {
			System.out.println(name+ " 大學部學生 " + "學號 : "+ID);
		}
		else if (id=='M') {
			System.out.println(name +" 碩士班學生"+ ", 學號 : "+ID);
		}
		else {
			System.out.println("Invalid input, please input a correct ID");
		throw new Exception();
		}
	
	}
	public void checklowestcredits(String ID, int credits) throws Exception {
		char id = ID.charAt(0);
		if(id=='B'&&credits<18) {
			System.out.printf("請重新加選以達到學士班低修門檻\n還需要%d學分",(18-credits));
		}
		if(id=='M'&&credits<12) {
			System.out.printf("請重新加選以達到碩士班低修門檻\n還需要%d學分",(18-credits));
		}
		if(credits>25) {
			System.out.println("已超修學分請重新修改");
		}
		else {
			throw new Exception();
		}
	
	}
	public void GPAcheck(String ID, double GPA) throws Exception {
		if(GPA<1.6) {
			course = "Fail";
		}
		if(GPA>=4.0&&GPA<=4.3) {
			course ="A+";
		}
		if(GPA>=3.7&&GPA<=4.0) {
			course ="A";
		}
		if(GPA>=3.4&&GPA<=3.7) {
			course = "A-";
		}
		if(GPA>=3.1&&GPA<=3.4) {
			course = "B+";
		}
		if(GPA>=2.8&&GPA<=3.1) {
			course = "B";
		}
		if(GPA>=2.5&&GPA<=2.8) {
			course = "B-";
		}
		if(GPA>=2.2&&GPA<=2.5) {
			course = "C+";
		}
		if(GPA>=1.9&&GPA<=2.2) {
			course = "C";
		}
		if(GPA>=1.6&&GPA<=1.9) {
			course = "C-";
		}
		else {
			throw new Exception();
		}
	System.out.println("Grade : " + course);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
