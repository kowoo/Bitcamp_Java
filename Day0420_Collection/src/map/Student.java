package map;


public class Student {
	
	private Score score;
	private String name;
	private int grade;
	
	public Student() {
		name = "이름없음";
		grade = 1;
		//Score의 기본 생성자 호출 : 점수가 0으로 초기화 됨
		score = new Score();
	}
	
	public Student(String name, int grade, Score score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
	}
	public Student(String name, int grade, int kor, int eng, int math) {
		this.name = name;
		this.grade = grade;
		score = new Score();
		score.setKor(kor);
		score.setEng(eng);
		score.setMath(math);
	}
	
	public String toString() {
		return String.format("이름 : %s, 학년 : %d%n성적 : %s, 평균 : %.1f점", name, grade, score, getAverage());
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	
	public void setScore(int kor, int eng, int math) {
		this.score = new Score(kor, eng, math); //새로운 스코어 객체를 만들어서 저장함, 가비지컬렉터에 의해 둘의 결과는 같음.(이전 객체가 삭제되므로)
//		score.setKor(kor);
//		score.setEng(eng);
//		score.setMath(math); // 기존의 스코어 객체에 저장함
	}
	
	public double getAverage() {
		double result = (double)(score.getKor()+score.getEng()+score.getMath())/3;
		return result;
	}
	
	//국어점수 설정하는 메서드
	public void setKor(int kor) {
		//내가 받아온 점수를 내 점수(score 객체)에다가 세팅
		score.setKor(kor);
	}
	//영어점수 설정하는 메서드
	public void setEng(int eng) {
		//내가 받아온 점수를 내 점수(score 객체)에다가 세팅
		score.setEng(eng);
	}
	//수학점수 설정하는 메서드
	public void setMath(int math) {
		//내가 받아온 점수를 내 점수(score 객체)에다가 세팅
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
	
	
	//메서드
	//평균점수를 반환하는 메서드 : getAverage();
	//getter/setter/toString
	
	
}
