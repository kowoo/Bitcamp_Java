package Day0412;

public class Sc {
	protected int kor; //protected : 같은 패키지 안의 외부 클래스에서만 접근 허용. 단, 상속된 관계일 경우 다른 패키지라도 사용가능(디폴트와 다른 점)
	protected int eng;
	
	public Sc() {
		kor=0;
		eng=0;
	}
	
	public Sc(int kor, int eng) {
		this.kor = kor;
		this.eng = eng;
	}
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor= kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng= eng;
	}
	
	public String toString() {
		return "[kor] : "+kor+", [eng] : "+eng;
	}
}
