package student;

import java.io.Serializable;

public class Student implements Serializable{
	//이름(문자열),학년(정수),점수(국,영,수:Score)
	//name,     grade , score
	//생성자 : 기본생성자
	//    : 매개변수가 (이름,학년,Score) 인 생성자  
	//    : 매개변수가 (이름,학년,국어,영어,수학) 인 생성자
	
	//메서드
	//평균점수를 반환하는 메서드 : getAverage()
	//getter/setter/toString
	//테스트 하실분들은 StudentTest 클래스 작성
	//국영수 점수를 각각 저장하지 못합니다. 각 점수를 따로 설정할 수 있는 메서드 만들기
	//setKor,setMath,setEng
	
	//transient : 직렬화 대상에서 제외
//	private transient String name;
	private String name;
	private int grade;
	private Score score;
	
	public Student() {
		name = "이름없음";
		grade = 1;
		//Score의 기본 생성자 호출: 점수가 0으로 초기화
		score = new Score(); 
	}
	public Student(String name,int grade, Score score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
	}
	public Student(String name,int grade,int kor,int eng,int math) {
		this.name = name;
		this.grade = grade;
		//점수는 Score 객체에 저장이 되어야 한다. 
		this.score = new Score(kor,eng,math); 
	}
	
	public double getAverage() {
		double result = (double)(score.getKor() 
				+ score.getEng() + score.getMath())/3;
		return result;
	}
	
	//국어점수 설정하는 메서드
	public void setKor(int kor) {
		//내가 받아온 점수를 내 점수(score 객체)에다가 세팅
		score.setKor(kor);
	}
	//영어점수 설정하는 메서드
	public void setEng(int eng) {
		score.setEng(eng);
	}
	//수학점수 설정하는 메서드
	public void setMath(int math) {
		score.setMath(math);
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
	public Score getScore() {
		return score;
	}
	
	public void setScore(Score score) {
		this.score = score;
	}
	public void setScore(int kor,int eng,int math) {
		this.score = new Score(kor, eng, math);
//		score.setKor(kor);
//		score.setEng(eng);
//		score.setMath(math);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", score=" + score 
				+ ",average ="+getAverage()+"] ";
	}
} 