package object;

public class Score {
	private int eng;
	private int math;
	
	public Score() {
		eng=0;
		math=0;
	}
	
	public Score(int eng, int math) {
		this.eng = eng;
		this.math = math;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public String toString() {
		return String.format("영어: %d점, 수학 %d점", eng, math); 
	}
	
}
