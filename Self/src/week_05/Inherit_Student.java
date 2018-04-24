package week_05;

public class Inherit_Student {
	private String name;
	public int grade;
	
	public Inherit_Student() {
		name="없음";
		grade=0;
	}
	
	public Inherit_Student(String name, int grade) {
		this.name=name;
		this.grade=grade;
	}
	
	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return String.format("이름: %s, 학년: %d", name, grade);
	}
	
	
}
