package student;

import java.io.Serializable;

public class Score implements Serializable {
	private int kor;
	//private transient int eng; 직렬화 제외
	private int eng;
	private int math;
	
	public Score() {
	}
	
	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String toString() {
		return String.format("국어 %d점, 영어 %d점, 수학 %d점", kor, eng, math);
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
	
	//점수를 저장할 수 있는 클래스
	//kor,eng,math
	//getter/setter 
	//만들고,toString

	
	
}
