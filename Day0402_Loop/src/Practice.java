import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		//while - break 연습 예제
		//사용자에게 숫자(정수)를 입력받아서 계속해서 더한다
		//-1을 입력받으면 그 전까지 더한 숫자의 총합과 평균을 출력하는 프로그램을 작성
		// 단, 평균은 소수점 둘째자리 반올림.
		// 예)
		// 5
		// 10
		// 6
		// 7
		// -1
		// 총합 28 평균은 7.0 입니다.

		//숫자를 입력받기 위해 Scanner, 정수 변수, 입력받은 정수를 더 할 변수
		//while문을 이용해야 하므로 while문. break를 위해 if문 추가

		Scanner sc = new Scanner(System.in); // 입력받기 위해 스캐너 클래스 선언.
		int sum = 0; // 합계 저장을 위한 변수
		int counts = 0; // 입력 횟수 저장을 위한 변수
		double aver; // 평균 저장을 위한 변수
		int i; // 입력받은 값 저장
		// 초기화를 하지 않을 경우 아무런 값이 없는 상태라고 가정되어 컴파일 오류가 발생한다.

		while(true) { // 반복
			i = sc.nextInt();
			if(i==-1) { // i가 -1일 경우 종료하기 위한 조건문
				break; // 종료
			}
			sum+=i; // 합계 저장
			++counts; // 입력 횟수 저장
		}
		aver=(double)sum/counts; // 평균 저장, 강제변환하지 않으면 정수/정수 이후 자동변환이므로 소수값 손실발생
		System.out.printf("총합은 %d 평균은 %.1f 입니다.", sum, aver); // -1일 경우 출력할 출력문


		/*강사님이 작성한 코드
		 * 필요한 변수 : 총합 저장 변수, 개수 저장 변수, 입력 변수
		 * 
		 * 1. 수를 하나 입력 받는다
		 * 2. 입력받은 수가 -1인지 확인
		 * 3-1 : -1이라면 반복을 종료하고 총합과 평균을 계산
		 * 3-2 : 아니라면 입력받은 수를 총합에 더하고, 개수를 1증가
		 * 4. 1~3 반복
		 *
		 * int sum = 0;	//총합을 저장할 변수
		 * int number; //사용자에게 수를 입력받을 변수
		 * int count = 0; //입력받은 수의 개수를 세기 위한 변수
		 *
		 * //몇 번 반복인지 알 수 없음 == while문을 사용
		 * //while(조건문) 조건문 자리에는 논리값이나 논리식이 온다
		 * Scanner scan = new Scanner(System.in);
		 *
		 * while(true) {
		 * 		//1. 사용자에게 숫자를 입력받는 것을 반복
		 * 		System.out.println("숫자를 입력하세요.");
		 * 		number = scan.nextInt();
		 * 		//2. 입력받은 수가 -1인지 아닌지 확인
		 * 		if(number == -1) {
		 * 		// 반복종료
		 *		// break;
		 * 		} //if end
		 * 		sum = sum+number; // -1이 아니라면 총합에 입력받은 수를 더한다
		 * 		count++; // -1이 아니라면 입력받은 숫자의 개수를 올린다
		 * } // while end
		 * 
		 * 	// 반복분이 끝나고 나면 총합과 평균을 계산
		 * avg = (double)sum/count;
		 * System.out.println("입력하신 수" + count + "개의 총합은 " +sum);
		 * System.out.printf("평균은 %.1f 입니다, avg");
		 */



	}
}
