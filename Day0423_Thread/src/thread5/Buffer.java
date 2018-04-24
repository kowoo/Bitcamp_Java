package thread5;

public class Buffer {
	/* 생산자 - 소비자 문제 해결을 위해 Buffer에서 해야할 일
	 * 소비자(get() 호출)
	 * 	1. 자원이 없으면 가져가지 않고 기다림.
	 * 	2. 생산자가 자원을 만들었다는 것을 알려줄 때 까지!
	 *  3. 생산자가 자원을 생성하고 알려주면 가져감.
	 *  4. 그리고 자원을 가져갔음을 생산자에게 알려줌.
	 * 생산자(put() 호출)
	 * 	1. 자원이 충분하면 자원을 생성하지 않는다.
	 *  2. 소비자가 자원을 사용할 때까지 기다린다.
	 *	3. 소비자가 자원을 사용했다고 알려주면 자원을 생성
	 *  4. 자원을 생성했다고 소비자에게 알려줌
	 */
	private boolean empty;
	private int data;
	
	public Buffer() {
		empty = true;
	}
	
	public synchronized int get() {
		while(empty==true) {
			try {				
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		empty = true;
		notifyAll();
		return data;
	}
	
	public synchronized void put(int data) {
		while(empty==false) {
			try {				
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		this.data = data;
		empty = false;
		notifyAll();
	}

}
