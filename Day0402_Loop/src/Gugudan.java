import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
		/*
		 * 구구단 2단 출력하기
		 * 
		 * 예)
		 * 2 X 1 = 2
		 * 2 X 2 = 4
		 * .
		 * .
		 * .
		 * 2 X 9 = 18
		 */

		for(int b=1;b<=9;b++) {
			System.out.println("2 X "+b+" = "+2*b);
			//System.out.printf("%d X %d = %d%n", c, d, c*d);
		}
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 하나 입력해주세요.");
		int num = sc.nextInt();
		for(int e=1; e<=9; e++ ) {
			System.out.printf("%d * %d = %d%n", num, e, num*e);
		}
		
		/*
		 * 구구단 거꾸로 출력하기
		 * 
		 * 예)
		 * 2 X 9 = 18
		 * 2 X 8 = 16
		 * .
		 * .
		 * .
		 * 2 X 1 = 2
		 */
		System.out.println();
		int d = 2;
		for(int c=9;c>=1;c--) {
			System.out.printf("%d X %d = %d%n", d, c, d*c);
		}
		

	}
}
