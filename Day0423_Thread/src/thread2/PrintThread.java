package thread2;

public class PrintThread extends Thread {
	//타겟쓰레드 상태값 출력
	//타겟쓰레드 실행시키고 상태값 모니터링
	//쓰레드의 상태값 받아오기: getState()

	Thread targetThread;

	//모니터링을 위한 타겟쓰레드 생성자 파라미터로 받아오기
	public PrintThread(TargetThread target) {
		this.targetThread = target;
	}
	
	
	public void run() {
		//타겟쓰레드 실행 및 상태 모니터링

		while(true) {
			//반복하며 쓰레드의 상태값 확인하기		
			Thread.State state = targetThread.getState();
			System.out.println("타겟쓰레드의 상태: "+state);
			
			if(state == Thread.State.NEW) { //파생쓰레드에서 또 다른 파생쓰레드를 만들 수 있다.
				targetThread.start();
			}else if(state == Thread.State.TERMINATED) {
				break;
			}
			/*****************************/
			try {
				//너무많은 출력을 방지하기 위해 0.1초간 모니터링 중지
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			/*****************************/
		}
	}
}
