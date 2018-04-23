import java.util.Scanner;

public class BreakEx {

	public static void main(String[] args) {
		//반복문의 조건식의 참, 거짓과 상관없이 반복문을 종료할때도 break를 사용하면 된다.
		//break를 만나면 반복문을 더 이상 실행하지 않고 즉시 종료하게 된다.

		int i =1;
		while(true) {
			System.out.println("i:"+i);
			if(i==2) {
				break; // break를 통해 10바퀴만 반복하게 만들 수 있다.
			}
			i++;
		}

		// 예제. 사용자에게 숫자를 입력받고, *2를 하여 출력한다.
		// 		단, -1을 입력받으면 출력하지 않고 종료한다.
		// 생각
		// 일단 숫자를 입력받기 위해 변수를 선언(정수)
		// 입력받기 위해 스캐너 클래스 선언
		// 입력받으면 *2로 돌려주지만 횟수 제한이 없으므로 반복문 사용.
		// -1을 입력받을 경우 종료하기 위해 조건문도 사용.

		Scanner sc = new Scanner(System.in); // 숫자를 입력받기 위해 선언

		while(true) { // -1을 입력하지 않으면 반복해서 실행된다.
			System.out.println("숫자를 입력하세요! (-1 입력시 종료)");
			int input = sc.nextInt(); // 입력한 숫자를 저장할 변수 선언
			
			if(input==-1) { // -1을 입력하면 종료하기 위한 조건문
				System.out.println("종료");
				break; // -1이 될 경우 while을 빠져나오기 위해 사용
			} else { // -1 외의 숫자를 입력할 경우 *2를 출력하기 위해 사용
			System.out.printf("%d X %d는 %d입니다.%n", input, input, input*2);
			}
		}

	}

}
