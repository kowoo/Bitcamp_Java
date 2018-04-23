import java.util.Scanner;

public class FindValue3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year;
		String leapYear, leap;
		System.out.print("연도를 입력해주세요 : ");
		year = scan.nextInt();

		leapYear = (year%4==0 && year%100!=0)? year+"년은 윤년입니다."
				:(year%400==0? year+"년은 윤년입니다.": year+"년은 평년입니다.");
		System.out.println(leapYear);

		leap = (year%4==0 && year%100!=0)? "윤년" // 1) 4로 나누어 떨어지면서 100으로 나누어 떨어지지 않는 연도는 윤년이다.
				:(year%400==0? "윤년": "평년"); // 1)이 아니라고 했을 때 400으로 나누어 떨어지면 윤년이지만 아니라면 평년이다.
		System.out.printf("%d년은 %s입니다.", year, leap);

	}

}
