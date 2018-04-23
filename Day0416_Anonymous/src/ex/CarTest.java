package ex;

public class CarTest {
	public static void main(String[] args) {
		//Tire koreaTire = new KoreaTire();
		Tire chinaTire = new Tire() {
			public void roll(int x) {
				System.out.println("중국산 타이어였어요");
			}
		};
		
		Tire chinaTire1 
		= (a)->{System.out.println(a+ "중국타이어 굴러가다 터짐");
			return;
		}; 
		// 현재 위는 출력 안한 상태
		
		Car myCar1 = new Car(
				(a)->{System.out.println(a+"으아아아");}
				);
		myCar1.drive();
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Car myCar2 = new Car(chinaTire1);
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Car myCar2 = new Car(new Tire() {
//			public void roll() {
//				System.out.println("중국산 타이어였어요");
//			}
//		myCar2.drive();
//		});
		
		//Tire chinaTire1 = (a)-> {System.out.println(a+"중국산 타이어였어요");};
		//Tire chinaTire1 = ()-> {System.out.println("중국산 타이어였어요");}; 여러줄 쓰고 싶으면 {}넣으면 되고 아니면 위와 같이 ()로도 가능하다

		
		//위의 방법으로 해도 되고 아래의 방법으로 해도 된다.
		//익명 클래스 사용 연습
		
	}
}
