
public class ThreadTest3 {
	public static void main(String[] args) {
		//멀티쓰레드 만들기2
		//Runnable 인터페이스 구현해서 Thread에서  실행하기
		//MyRunnable : Runnable 구현 클래스
		//MyRunnable 객체를 Thread로 넘겨 주면 된다.
		Runnable runnable = new MyRunnable();
		//Thread 생성자의 파라미터 인자로 runnable 객체 넘겨주기
		Thread thread1 = new Thread(runnable);
		//파생 쓰레드 생성
		thread1.start();
		
		for(int i=0; i<100; i++) {
			System.out.println("메인 쓰레드: "+i);
		}
	}
}
