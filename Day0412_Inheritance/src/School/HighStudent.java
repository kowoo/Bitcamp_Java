package School;

public class HighStudent extends Student{
	String regNumber;
	
	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	
	public void tryTabaco() {
		System.out.println("에세 라이트요");
	}
}