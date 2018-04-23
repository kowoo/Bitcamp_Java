package thread4;

public class Producer implements Runnable {
	//데이터를 만들어내는 역할
	private Buffer buffer;
	private int data; //버퍼에 넣을 데이터
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		for(int i=1; i<=10; i++) {
			data = i;
			System.out.println("생산자가 데이터 "+data+"를 생산했습니다.");
			buffer.put(data);
			
			try {
			Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e) {
				e.getStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
}
