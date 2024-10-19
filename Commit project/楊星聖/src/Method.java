package Java_class_023_Student_System_Project;

class UndergraduateStudent extends StudentAccount{
	private int year;
	private String major;
	
	//大學生
	public UndergraduateStudent( String studentNumber,String studentName, int studentAge, double GPA,int year,String major) throws Exception {
		super(studentNumber,studentName, studentAge, GPA);
		if(year>4) {
			throw new Exception("年級不能超過4");
		}else if(year<1){
			throw new Exception("年級不能低於1");
		}
		this.year = year;
		this.major = major;	
		}
	@Override
	public String toString() {
		return super.toString() + ", 年級: "+ year+ ", 主修: "+major;
		}
	}
	
	//研究生
	class GraduateStudent extends StudentAccount{
		private String researchtopic;
		private String supervisor;
		
		public GraduateStudent( String studentNumber,String studentName, int studentAge, double GPA,String researchtopic,String supervisor) throws Exception {
			super(studentNumber, studentName, studentAge, GPA);
			this.researchtopic = researchtopic;
			this.supervisor = supervisor;
		}
		
		@Override
		public String toString() {
			return super.toString() + ", 研究主題: "+researchtopic+", 指導教授: "+supervisor;
		}
	
	
}