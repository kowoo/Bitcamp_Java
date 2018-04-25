package thread2;

public class TargetThread extends Thread  {
	//이 쓰레드의 상태값을 PrintThread가 출력.

	public void run() {
		for(long i=0; i<2000000000; i++) {
			try {
			//쓰레드의 진행을 잠시 멈춤: 상태값의변화를줘서 모니터링 하기 위함
			Thread.sleep(1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
