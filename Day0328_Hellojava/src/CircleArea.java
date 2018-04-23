import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {
		// 원의 넓이를 구하는 프로그램 작성
		// 반지름(정수)을 입력받아서 원의 넓이를 구하는 프로그램
		// 1. 변수 타입을 지정한다.
		// 2. 입력받을 준비를 한다.
		// 3. 입력을 받는다.
		// 4. 계산 결과를 보여준다.

		int radius;	// 반지름 값을 저장할 변수 타입을 선언
		double area; // 결과(원넓이) 값을 저장할 변수 타입을 선언
		Scanner scan = new Scanner(System.in); // 값을 입력받을 준비

		System.out.print("반지름을 입력해주세요 : "); // 입력을 안내
		radius = scan.nextInt(); // 입력한 값을 radius에 저장

		area = 3.14*radius*radius; // 원넓이 계산
		System.out.printf("원의 넓이는 %.2f입니다.%n", area);
		System.out.println("원의 넓이는 " + area + "입니다."); // 결과값 출력
		// System.out.println() sysout 타이핑 후 Ctrl + Space로 가능. syso 타이핑 후 Ctrl + Space + Enter로도 가능

	}

}
