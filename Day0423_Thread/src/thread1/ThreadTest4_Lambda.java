package thread1;

public class ThreadTest4_Lambda {
	public static void main(String[] args) {
		//Runnable 익명클래스로 구현해서 쓰레드 실행시키기
//		Runnable r1 = new Runnable() { 익명 클래스! 잘 쓰이니 구조를 기억하자.
//			public void run() {
//				for(int i=10; i>0; i--) {
//					System.out.println(i);
//				}
//			}
//		};
		
		
		//인터페이스나 추상클래스의 메서드가 하나 뿐 일때 람다식을 이용할 수 있다.
		Runnable r1 = ()-> {
			for(int i=10; i>0; i--) {
				System.out.println(i);
			}
		};
		
		
		Thread t1 = new Thread(r1);
		t1.start();
		//쓰레드를 실행시키는건 스타트()밖에 없다.
		//하지만 런을 실행하는게 2가지.
		
	}
}
