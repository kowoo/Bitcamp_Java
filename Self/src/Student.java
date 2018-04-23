
public class Student {
	private String name;
	private int number;
	private Score score;
		
	public Student() {
		score = new Score();
		name = "이름없음";
		number = 0;
	}
		
	public Student(String name, int number, Score score) {
		this.name = name;
		this.number = number;
		this.score = score;
	}
	public Student(String name, int number, int kor, int eng, int math) {
		this.name = name;
		this.number = number;
		this.score = new Score(kor, eng, math);
	}
	
	public int getKor() {
		return score.getKor();
	}
	public int getEng() {
		return score.getEng();
	}
	public String getName() {
		return name;
	}


	public int getMath() {
		return score.getMath();
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setKor(int kor) {
		score.setKor(kor);
	}
	public void setEng(int eng) {
		score.setEng(eng);
	}
	public void setMath(int math) {
		score.setMath(math);
	}
	
	public double getAvg() {
		return ((double)score.getKor()+score.getEng()+score.getMath())/3;
	}
	
	public String toString() {
		return String.format("이름 : %s%n번호 : %d%n성적 : %s%n평균 : %.1f%n", name, number, score, getAvg());
	}
	
		

}
