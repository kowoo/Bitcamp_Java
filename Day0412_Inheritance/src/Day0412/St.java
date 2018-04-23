package Day0412;

public class St {
	Sc score;
	private String name; //private : 외부 클래스에서 접근 불가, 같은 클래스에서는 자유롭게 수정 가능
	public int grade; //public : 자유롭게 접근 가능
	
	public St() { //기본 생성자. 초기화 담당
		score=new Sc();
		name="";
	}
	public St(String name, int grade, Sc score) { //생성자. 매개변수를 받아서 멤버 변수에 저장.
		this.name = name;
		this.grade = grade;
		this.score = score;
	}
	
	public String getName() { //값을 얻기 위한 getter 메서드. 반환자는 반환할 값과 타입이 같아야함. 리턴도 마찬가지.
		return name;
	}
	public void setName(String name) {//값을 수정하기 위한 setter 메서드. 반환자가 없다. 수정을 원하는 값과 같은 타입의 매개변수가 필요.
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "St [name=" + name + ", grade=" + grade + ", score=" + score + "]";
	}
	
	
}
