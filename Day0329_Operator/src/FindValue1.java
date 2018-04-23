import java.util.Scanner;

public class FindValue1 {

	public static void main(String[] args) {
		
		//예제1 : 사용자에게 숫자 2개를 입력받아서 어떤 숫자가 더 큰지 알려주는 프로그램을 작성.
		/* 
		 * 실행 예) 숫자 1을 입력하세요.
		 *		  3
		 * 		   숫자 2을 입력하세요.
		 *		  5
		 * 		  더 큰 숫자는 5입니다.
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		int num0, num00, win;
		String winner;

		System.out.print("첫 번째 숫자를 입력하세요 : ");
		num0 = scan.nextInt();
		System.out.print("두 번째 숫자를 입력하세요 : ");
		num00 = scan.nextInt();

		win = num0 < num0? num0: (num0 == num00? num00 : num0);
		winner = num0 < num00? "두 번째 숫자": (num0 == num00? "없으며 숫자는" : "첫 번째 숫자");
		System.out.printf("큰 숫자는 %s %d입니다.%n%n", winner, win);
	}

}
