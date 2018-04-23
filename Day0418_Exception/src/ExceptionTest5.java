import java.io.IOException;

public class ExceptionTest5 {
	public static void main(String[] args) {
		//finally
		
		Student s = new Student(300,3);
		
		try {
			s.showAverage();
			System.out.println("try 정상 종료");
			return; //리턴은 메서드를 탈출한다
		}catch(IOException e) {
			System.out.println("IOException 발생");
		}catch(Exception e) {
			System.out.println("Exception 발생");
		}finally { // 실행결과와 상관없이 항상 실행
			System.out.println("얘는 무조건 실행돼요");
		}
		System.out.println("프로그램 종료");
		
	}
}
