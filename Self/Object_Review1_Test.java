import java.util.Scanner;

public class Object_Review1_Test {
	//사용자로 부터 숫자 n개를 입력받아서
	//작은 순으로 출력하는 프로그램을 작성하자
	//입출력 예)
	// 비교할 숫자의 개수를 입력하세요 : 4
	// 숫자1을(를) 입력하세요 : 1
	// 숫자2을(를) 입력하세요 : 2
	// 숫자3을(를) 입력하세요 : 3
	// 숫자4을(를) 입력하세요 : 4
	// 입력한 숫자의 내림차 순은 4, 3, 2, 1 입니다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("비교할 숫자의 개수를 입력하세요 : ");
		int num = sc.nextInt();
		Object_Review1 o1 = new Object_Review1(num);
		o1.toString();

		

		
	}
}