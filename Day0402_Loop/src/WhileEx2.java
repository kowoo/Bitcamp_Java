import java.util.Scanner;

public class WhileEx2 {
	public static void main(String[] args) {
		/*
		 * 예제. 사용자에게 숫자를 하나 입력받아서 1부터 입력받은 수 사이의
		 * 짝수를 출력하기
		 * 
		 * 예)
		 * 숫자를 입력하세요.
		 * 11
		 * 2 4 6 8 10
		 * while, if 사용
		 *
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int num = scan.nextInt();
		int a;
		a = 1;
		
		while (a <= num) {
			if (a%2 == 0) {
				System.out.print(a+" ");
			}
			a++;
		}
		
		System.out.println("");
		System.out.println("");
		
		//강사님이 작성한 코드
		System.out.println("숫자를 입력하세요.");
		int number = scan.nextInt();
		int n = 1;
		while (n <= number) {
			//출력되는 부분을 n이 짝수 일때만 출력하고 싶다.
			if(n%2==0) {
				//짝수
				System.out.print(n+" ");
			} //홀 수 일때는 출력하면 안되니까 작성하지 않는다
			n++; //반복문 안에서 반복계수는 1씩 증가시켜야 하므로 n++
		}
		


	}
}