package thread1;

public class ThreadTest {
	public static void main(String[] args) {
		//반복문 2개 단일 쓰레드(메인 쓰레드)
		
		for(int i=0; i<100; i++) {
			System.out.println("반복문1: "+i);
		}
		for(int i=0; i<100; i++) {
			System.out.println("반복문2: "+i);
		}
		System.out.println("메인 쓰레드 종료.");
	}
}
