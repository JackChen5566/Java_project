package Java_class_project2;

class GraduateStudent extends StudentAccount{
	private String StudyField;
	private String Advisor;
	
	public GraduateStudent(String studentNumber, String studentName, int studentAge, String StudyField, String Advisor) {
		super(studentNumber, studentName, studentAge);
		this.StudyField = StudyField;
		this.Advisor = Advisor;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Major:"+StudyField+", Advisor:"+Advisor;
	}
	
}

class CollegeStudent extends StudentAccount{
	private String Year;
	private String Major;
	
	public CollegeStudent(String studentNumber, String studentName, int studentAge, String Major, String Year) {
		super(studentNumber, studentName, studentAge);
		this.Year = Year;
		this.Major = Major;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Year:"+Year+", Major:"+Major;
	}
	
}