package thread1;

public class HorseRace2 {
	public static void main(String[] args) {
		/* 말 경주하기
		 * 반복적으로 랜덤(1~5) 숫자를 만들어내는 클래스(Horse)를 만들고
		 * 누적 합이 50이상이면 레이스를 종료 
		 */
		Horse2 h1 = new Horse2("번개");
		Horse2 h2 = new Horse2("적토마");
		Horse2 h3 = new Horse2("슈팅스타");
		Horse2 h4 = new Horse2("다크호스");
		Horse2 h5 = new Horse2("유니콘");
		
		//Animal a = h1;
		Runnable r1 = h1;
		Runnable r2 = h2;
		Runnable r3 = h3;
		Runnable r4 = h4;
		Runnable r5 = h5;
		//이런 유연성 덕분에 extends Thread보다 implements Runnable이 더 많이 쓰인다.
		//Horse2 클래스는
		//Animal 클래스를 상속 받으면서 Runnable을 구현하기 때문에
		//두 클래스 참조변수에 모두 참조될 수 있다.
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		Thread t5 = new Thread(r5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
