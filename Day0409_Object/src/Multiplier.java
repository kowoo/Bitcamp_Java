
public class Multiplier {
	int result;
	double resultDouble;
	public Multiplier(int number) {
		System.out.println("Multiplier의 생성자 입니다.");
		result = number;
	}
	public Multiplier() {
		System.out.println("Multiplier의 기본 생성자 입니다.");
	}
	public int multiply(int x, int y) {
		System.out.println("정수곱");
		result = x*y;
		return result;			
	}	
	public double multiply(double x, double y) {
		System.out.println("실수곱");
		resultDouble = x*y;
		return resultDouble;			
	}	
}
