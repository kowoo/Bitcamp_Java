package thread1;

public class ThreadTest2 {
	public static void main(String[] args) {
		//멀티쓰레드 만들기
		//쓰레드 실행 방법
		//Thread 클래스 객체를 만들고 start() 메서드 호출
		Thread thread1 = new MyThread();
		thread1.start(); //파생 쓰레드
		//start를 실행하면 thread가 가지고 있는 run() 메서드를 실행
		//기본적으로는 아무 것도 정의되어 있지 않으므로 실행되지가 않는다.
		//	public void run() {
		//		이런 모양임
		//	} 그러므로 실행할 코드를 run()에 구현해야 한다. (상속, 오버라이딩)

		for(int i=0; i<100; i++) {
			System.out.println("메인쓰레드: "+i);
		}
		System.out.println("메인 쓰레드 종료.");

	}
}
