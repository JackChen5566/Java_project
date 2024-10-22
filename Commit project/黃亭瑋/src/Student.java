package java_project2;

public class Student {
	private String name;
	private String id;
	private int age;
	private int score;

	public Student(String name, String id, int age, int score) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.score = score;
	}

	public void Identity () {

	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void getgrade(int score) {

	}

	public String toString() {
		return "Name = " + name + ", ID =" + id + ", Age =" + age + ", score = " + score;

	}

}
