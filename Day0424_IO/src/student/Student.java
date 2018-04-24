package student;
public class Student {
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
	
	private String name;
	private int grade;
	private int score;
	
	public Student() {
		name = "이름없음";
		grade = 1;
		//Score의 기본 생성자 호출: 점수가 0으로 초기화
		score = 0;
	}
	public Student(String name,int grade, int score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
	}

	//점수 설정하는 메서드
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
		return String.format("이름: %s, 학년: %d, 점수: %d", name, grade, score);
	}
		
} 

