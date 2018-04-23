import java.util.Scanner;

public class Salary {
	public static void main(String[] args) {
		//예제) 사용자에게 일한 시간(정수)을 입력받고 시간 만큼의 수당을 계산해서
		//화면에 보여주는 프로그램을 작성하라
		
		/*
		1. 필요한 변수를 입력하자. 시간, 스캔, 수당
		2. 입력을 받기 위해 필요한 것은?
		3. if-else를 사용하자.
		4. 정규 근무시간은 8시간, 8시간 초과 근무시 추가 수당을 지급 받음.
		5. 시급은 7,530원. 초과 근무는 시급 1.5배가 적용된다.
		6. 예) 10시간을 일하면 8시간 시급 + 2시간*1.5배 시급 = 11시간 시급
		7. 급여는 소수점 둘째 자리까지 출력한다.
		8. 시간은 정수로만 입력받아야한다.
		*/
		
		int time, hw;
		double salary;
		boolean result;
		Scanner input = new Scanner(System.in);
		
		System.out.print("근무 시간을 입력하세요 : ");
		time = input.nextInt();
		final int HW = 7530;
		result = time<=8;
		
		if(result) {
			salary = time*HW;
		}else {
			salary = time*HW + (time-8)*0.5*HW;
		}
		System.out.printf("급여는 %.2f원 입니다.%n", salary);
		
		
		//강사님이 작성한 코드
		//입력받을 변수-정수, 결과(일당)를 저장할 변수-실수
		int hours;
		double salary1; //salary와 중복이라 1
		final int REG_HOURS = 8;
		final int TIME_PAY = 7530;
		final double OVER_PAY_RATE = 1.5;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("근무 시간을 입력하세요");
		hours = scan.nextInt();
		
		//근무 시간에 따라서 급여의 계산방법이 달라짐
		//8시간 이하 : hours * TIME_PAY
		//8시간 초과 : REG_HOURS*TIME_PAY + (hours-8)*TIME_PAY*OVER_PAY_RATE
		
		if(hours <= REG_HOURS) {
			salary1 = hours*TIME_PAY;
		}else {
			salary1 = 
					 REG_HOURS*TIME_PAY
					 + (hours-REG_HOURS)*TIME_PAY*OVER_PAY_RATE;
		}
		System.out.printf("급여는 %.2f원 입니다.", salary1);
		
	}

}
