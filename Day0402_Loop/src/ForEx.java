
public class ForEx {
	public static void main(String[] args) {
		//반복문 for
		/*
		 * for(초기화;조건식;증감식) {
		 * 		문장;
		 * }
		 * 1. 초기화는 최초 한 번만 실행
		 * 2. 조건식이 참이면 문장을 실행
		 * 3. 문장을 실행한 이후 증감식 실행
		 * 4. 증감식 실행 후, 조건식을 다시 검사
		 * 5. 참이면, 2~4 반복
		 * 6. 거짓이면 종료 (for문 바깥으로 나옴)
		 */
		
		// 1부터 10까지 출력하기
		// while
		
		int a = 1; // 반복 계수 선언 및 초기화
		while(a<=10) { // while 조건 검사
			System.out.print(a+" "); // a 출력
			a++; //반복 계수 증가
		}
		
		System.out.println();
		
		for(int b=1; b<=10; b++) { // 변수(==b)가 반복문 외부에서 사용되지 않는다면 이렇게 해도 무방하다.
			System.out.print(b+" ");
		}
		
	}

}
