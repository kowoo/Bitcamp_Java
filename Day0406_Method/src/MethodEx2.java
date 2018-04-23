
public class MethodEx2 {
	public static void main(String[] args) {
		//메서드를 만든다.
		//수식자는 public static
		//이름은 add
		//매개변수는 정수2개
		//반환형은 정수
		//반환값은 매개 변수 2개를 더한 값
		
		//두 정수를 입력받아서 나머지 값을 반환하는 메서드 작성
		//mod
		
		int a = add(3, 4);
		System.out.println(a);
		
		int b = mod(5, 5);
		System.out.println(b);
		
		
	}
	//여기다가 작성
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static int mod(int a, int b) {
		return a%b;
	}
}