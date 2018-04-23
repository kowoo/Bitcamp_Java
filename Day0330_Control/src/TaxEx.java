import java.util.Scanner;

public class TaxEx {
	public static void main(String[] args) {
		//사용자로부터 연봉(정수, 만원)을 입력받아 소득세를 구하는 프로그램 작성
		/*	
		세율 기준
		2000만원 이하 9%
		2000만원 초과 4000만원 이하 18%
		4000만원 초과 8000만원 이하 27%
		8000만원 초과 36%
		 */
		// 무엇을 해야할지 정리해보자.
		// 1. 연봉을 입력받아야 한다. Scanner, int 변수 값 등을 준비
		// 2. 세율이 어느 구간에 해당하는지 검사해야한다.
		// 3. 출력!
		// 4. if-else if 문을 사용해서 만들어보자.
		
		Scanner sc = new Scanner(System.in);
		int money;
		int tax = 0;
		double result;
		final char PER = '%';
		final int TAX_1_MONEY = 2000;
		final int TAX_1_PHASE = 9;
		final int TAX_2_MONEY = 4000;
		final int TAX_2_PHASE = 18;
		final int TAX_3_MONEY = 8000;
		final int TAX_3_PHASE = 27;
		final int TAX_4_PHASE = 36;
		
		System.out.print("연봉을 입력하세요(단위 : 만원, 정수) : ");
		money = sc.nextInt();
		
		if(money<=TAX_1_MONEY) {
			tax = TAX_1_PHASE;
		}else if(money<=TAX_2_MONEY) {
			tax = TAX_2_PHASE;
		}else if(money<=TAX_3_MONEY) {
			tax = TAX_3_PHASE;
		}else {
			tax = TAX_4_PHASE;
		}
		result = money*(tax/100.0);
		System.out.printf("연봉 %d만원에 대한 소득세는 %d%c인 %.1f만원 입니다.%n", money, tax, PER, result);
		System.out.println("연봉 "+money+"만원에 대한 소득세는 "+(tax+"%")+"인 "+(int)(result)+"만원 입니다.");	
		
	}

}