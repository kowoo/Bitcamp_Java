package student;

public class Student {
	//이름, 학년, 국영수 점수
	private String name;
	private int grade;
	private int kor;
	private int eng;
	private int math;
	//총합, 평균을 반환하는 메서드
	
	public Student() {}
	
	public Student(String name, int grade, int kor, int eng, int math) {
		super();
		this.name = name;
		this.grade = grade;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal() {
		return kor+eng+math;
	}
	
	public int getAverage() {
		return getTotal()/3;
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return name; //나중에 목록을 통해 표시할 때 보이는 글자가 toString
	}
	
	
	
	
}
