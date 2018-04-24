
public class ExceptionTest4 {
	public static void main(String[] args) throws Exception{ //쓰로우 익셉션을 통해 다른 곳으로 보내줄 수도 있다.
		//예외 처리 책임 전가 시키기 : throws 예외
		
		Student s = new Student(300,0);

		//예외 발생함
		try{
			s.showAverage();
		}catch(Exception e) {
			System.out.println("예외 처리완료");
		}
		System.out.println("프로그램 종료");
	}
}