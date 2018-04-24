package thread5;

public class Pro implements Runnable{
	private int data;
	private Buffer buf;
	
	public Pro(Buffer buf) {
		this.buf = buf;
	}
	
	public void run() {
		for(int i=1; i<=5; i++) {
			data = i;
			System.out.println("생산자가 데이터 "+data+"를 생산했습니다.");
			buf.put(data);
			
			try {
				Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
