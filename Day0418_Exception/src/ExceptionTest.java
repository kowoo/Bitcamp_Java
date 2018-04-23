
public class ExceptionTest {
	public static void main(String[] args) {
		int x = 1;
		int y=0;
		
		//예외 처리 문장 : try-catch
		try{
			//예외 발생 예상구간
			int result = x/y;
		}catch(NullPointerException e){ //예외 객체
			//예외 발생시 실행할 문장
			System.out.println("없는데요?");
			e.printStackTrace();
		}catch(ArithmeticException e){ //예외 객체
			//예외 발생시 실행할 문장
			System.out.println("0으로는 못나눠요");
			e.printStackTrace();
		}
		
		System.out.println("1");
		
	}
}
