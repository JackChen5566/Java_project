package java_project2;

class ExtendsStudent extends Student { // 本科生
	public String topics; // 專題

	public ExtendsStudent(String name, String id, int age, int score, String topics) {
		super(name, id, age, score);
	}

	public String getTopics() {
		return topics;
	}

	@Override
	public String toString() {
		return "MasterStudent = " + super.toString() + ", Topics=" + topics;

	}

}

class MasterStudent extends Student { // 碩士生

	public String instructor, researchtopic; // 指導老師 & 論文

	public MasterStudent(String name, String id, int age, int score, String instructor, String researchtopic) {
		super(name, id, age, score);
	}

	public String getInstructor() {
		return instructor;
	}

	public String getResearchTopic() {
		return researchtopic;
	}

	@Override
	public String toString() {
		return "ExtendsStudent = " + super.toString() + ", Instructor=" + instructor + ", Researchtopic ="
				+ researchtopic;

	}
}