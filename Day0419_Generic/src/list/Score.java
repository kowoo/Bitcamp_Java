package list;

public class Score {
	public int kor;
	public int eng;
	
	public Score() {
		kor=0;
		eng=0;
	}
	public Score(int kor, int eng) {
		this.kor = kor;
		this.eng = eng;
	}
	
	public String toString() {
		return "kor: "+kor+" eng: "+eng;
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
	
}
