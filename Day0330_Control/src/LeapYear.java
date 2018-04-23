import java.util.Scanner;
public class LeapYear {
	public static void main(String[] args) {
		// 어제 작성했던 삼항 연산자 윤년 확인 프로그램을 if-else로 바꾸기
		/*
		처음에 바로 코딩을 하지말고 필요한 것들을 글로 적은 다음에 생각을 하고나서 코딩을 하자.
		윤년 확인 프로그램을 if-else를 사용하여 만들어야한다.
		1. 입력을 받기 위해 해야하는 것은?
		2. 어떤 타입의 변수가 필요할까?
		3. 윤년의 기준은?
		4. 기준을 맞추기 위해서 필요한 연산은?
		5. 어떻게 출력할까?
		 */
		Scanner scan = new Scanner(System.in);
		int year;

		System.out.print("연도를 입력해주세요 : ");
		year = scan.nextInt();

		if (year%400==0 && year%100!=0 || year%400==0) {
			System.out.println("입력하신 연도는 윤년입니다.");
		}else {
			System.out.println("입력하신 연도는 평년입니다.");
		}

		//강사님이 작성한 코드
		//연도를 사용자에게 입력받고 -scanner, year
		//입력받은 연도가 윤년인지 계산 - 조건식
		//계산 결과에 따라 출력 -if-else
		Scanner input = new Scanner(System.in);
		System.out.println("연도를 입력하세요");
		// int year;
		year = input.nextInt(); //입력받음
		
		if((year%4==0 && year%100 !=0)||(year%400==0)) {
			//윤년
			System.out.println(year + "년은 윤년입니다.");	
		}else {
			//평년
			System.out.println(year + "년은 평년입니다.");	
		}


	}
}