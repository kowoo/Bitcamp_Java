
public class ExceptionTest2 {
	public static void main(String[] args) {
		int a = 1;
		int b=0;
		int[] numbers = new int[3];
		numbers[0] = a;
		numbers[1] = b;
		int result=0;

		//반복문 밖에서 예외 처리를 하면 예외 발생시
		//반복문이 더 이상 실행되지 않는다.
//		try {
//			for(int i=0; i<4; i++) {
//				result = numbers[i]/b;
//			}
//		}catch(ArithmeticException e) {
//			e.printStackTrace();
//		}
		
		//반복문 안에서 예외를 처리하면 각 반복문마다 예외를 처리하는 것이므로
		//예외가 발생하더라도 반복문은 계속 실행된다
//		for(int i=0; i<4; i++) {
//			try {
//				result = numbers[i]/b;
//			}catch(Exception e) {
//				e.printStackTrace();
//				System.out.println("예외가 발생했습니다");
//			}
//		}
		
//		for(int i=0; i<4; i++) {
//			try {
//				result = numbers[i]/b;
//			}catch(Exception e) { //모든 예외를 다 잡아낸다.
//				e.printStackTrace();
//				System.out.println("예외가 발생했습니다");
//			}
//		}
		
		for(int i=0; i<4; i++) {
			try {
				result = numbers[i]/b;
			}catch(ArithmeticException|ArrayIndexOutOfBoundsException e) {
				//여러 오류를 하나의 catch문으로 처리하고 싶을때에는 위와 같이 |(or)을 이용하자
				result = 1;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램을 종료합니다.");
		
	}
}
