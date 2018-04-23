package list;

public class Student {	
	private Score score;
	private String name;
	private int grade;
	
	public Student() {
		score = new Score(); 
		name = "이름없음";
		grade = 1;
	}
	public Student(String name,int grade,Score score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
	}
	public Student(String name,int grade,int kor,int eng) {
		this.name = name;
		this.grade = grade;
		this.score = new Score(kor, eng);
	}
	
	public String toString() {
		return "이름 : "+name+" 학년 : "+grade+" "+score;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
} 