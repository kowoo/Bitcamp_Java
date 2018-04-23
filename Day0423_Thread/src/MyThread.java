
public class MyThread extends Thread {
	//Thread 클래스를 상속 받아서 run()을 재정의 한다.
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("MyThread : "+i);
		}
	}
}
