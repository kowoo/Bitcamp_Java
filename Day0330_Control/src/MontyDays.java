import java.util.Scanner;

public class MontyDays {
	public static void main(String[] args) {
		// 월을 입력받아서 일수를 구하는 프로그램을 작성하자.
		// 예) 월을 입력하세요.
		// 3
		// 3월은 31일 입니다.
		
		// 뭐가 필요할까?
		// 1. 입력받기 위한 스캐너
		// 2. 입력받은 값을 넣을 변수
		// 3. 입력받은 값이 며칠까지 있는지 확인할 조건문
		
		Scanner sc = new Scanner(System.in);
		System.out.print("월을 입력하세요 : ");
		int month;
		int days = 0;
		month = sc.nextInt();
		
		switch (month) {
		case(1): case(3): case(5): case(7):
		case(8): case(10): case(12):
			days = 31;
			break;
		case(4): case(6):
		case(9): case(11):
			days = 30;
			break;
		case(2):
			days = 28;
			break;
		default:
			System.out.println("1~12만 입력이 가능합니다.");
		}
		System.out.printf("%d월은 %d일 입니다.", month, days);
		
	}
}
