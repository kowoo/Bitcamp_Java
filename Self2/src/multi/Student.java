package multi;

import java.io.Serializable;
public class Student implements Serializable {
	
	//클래스의 버전 정보를 확인하는 데이터
	//클래스의 정보가 변경되었을때, 직렬화해서 객체를 만들어내면 문제가 발생할 수 있다.
	//클래스의 버전 정보를 저장하는 변수를 둬서 객체가 업데이트됐는지 확인하는 것.
	//이러면 문제 안생기나봄.. 그냥 그렇게 알아두자
	private static final long serialVersionUID = 5718489234304188739L;
	private String name;
	private int grade;
	private int score;
	
	public Student() {
		name="없음";
		grade=0;
		score=0;
	}
	public Student(String name, int grade, int score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", score=" + score + "]";
	}
}
