package thread5;

public class Cus implements Runnable {
	private int data;
	private Buffer buf;
	
	public Cus(Buffer buf) {
		this.buf = buf;
	}
	
	public void run() {
		
		for(int i=0; i<5; i++) {
			data = buf.get();
			System.out.println("소비자가 데이터 "+data+"를 소비했습니다.");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
