package object;

public class Student {
	private String name;
	private int age;
	Score score;
	
	public Student() {
		name="이름없음";
		age=0;
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Student(String name, int age, Score score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public Student(String name, int age, int eng, int math) {
		this.name = name;
		this.age = age;
		score.setEng(eng);
		score.setMath(math);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return String.format("이름: %s, 나이: %d, 영어: %d점, 수학: %d점", name, age, score.getEng(), score.getMath());
	}
	
	
}
