import java.util.Scanner;

public class MonthDays2 {
	public static void main(String[] args) {
		// 연, 월을 입력받아서 일수를 구하는 프로그램을 작성하자.
		// 연도를 입력하세요. 
		// 2000
		// 월을 입력하세요.
		// 2
		// 2000년 2월은 29일 입니다.

		// 뭐가 필요할까?
		// 1. 입력받기 위한 스캐너
		// 2. 입력받은 값을 넣을 변수
		// 3. 입력받은 값이 며칠까지 있는지 확인할 조건문
		// 4. if-else, switch, 삼항 연산식을 전부 활용해보자.
		
		// 윤년 구별법
		// 1. (year%4==0 && year%100 !=0)
		// 2. (year % 400 ==0)

		Scanner scan = new Scanner(System.in);
		int year;
		int months;
		int days=0;

		System.out.print("연도를 입력하세요 : ");
		year = scan.nextInt();
		System.out.print("월을 입력하세요 : ");
		months = scan.nextInt();

		switch(months) {
		case(1): case(3): case(5): case(7):
		case(8): case(10): case(12):
			days = 31;
			break;
		case(4): case(6):
		case(9): case(11):
			days = 30;
			break;
		case(2):
			if (months == 2 && year%4 == 0 && year%100 != 0) {
				days = 29;
			} else if(months == 2 && year%400 == 0) {
				days = 29;
			} else {
				days = 28;
			}
			break;
		default:
			System.out.println("1~12만 입력이 가능합니다.");
			break;
		}
		
		System.out.printf("%d년 %d월은 %d일까지 있습니다.", year, months, days);

	}
}
