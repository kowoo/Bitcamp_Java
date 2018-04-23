import java.util.Scanner;

public class ControlEx2 {
	public static void main(String[] args) {
		//예제 : 사용자에게 정수를 하나 입력 받아서 짝수인지 홀수인지 출력하는 프로그램 작성

		int num1;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해주세요 : ");
		num1 = sc.nextInt();

		if (num1%2==0) {
			System.out.println("입력하신 숫자는 짝수입니다.");
		}else {
			System.out.println("입력하신 숫자는 홀수입니다.");
		}


		//강사님이 작성한 코드
		Scanner input = new Scanner(System.in);
		int number;
		System.out.print("숫자를 입력하세요");
		number = input.nextInt();

		boolean result = number%2==0;

		if(result) { // 논리식 자체의 값이 true, false이므로 조건식을 논리타입 변수 하나로 구성해도 된다.
			System.out.println(number+"(은)는 짝수입니다.");
		}else {
			System.out.println(number+"(은)는 홀수입니다.");
		}
	}
}
