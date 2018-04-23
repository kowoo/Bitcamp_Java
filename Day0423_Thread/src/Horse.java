
public class Horse extends Thread {
	private String name;
	
	public Horse(String name) {
		this.name = name;
	}
	
	public void run() {
		int sum=0;
		while(sum<50) {
			int tmp = ((int)(Math.random()*5))+1;
			sum+=tmp;
			//쓰레드의 진행을 잠시 멈춤 sleep();
			try {
				Thread.sleep(10); //100 = 0.1초, 10이면 0.01초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(name+": "+sum);
		}
		System.out.println("레이스 종료");
	}
	
}
