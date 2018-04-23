package interface1;

public class InterfaceTest {
	public static void main(String[] args) {
		//참조변수 선언 가능
		Moveable m;
		//하지만 객체 생성이 안됨 : 상속용으로만 사용가능
		//m = new Moveable();
		
//		Animal[] animals = new Animal[2];
//		animals[0] = new Dog();
//		animals[1] = new Cat();
		
		
		//Moveable m1;
		
		Moveable[] m2 = new Moveable[2];
		m2[0] = new Dog();
		m2[1] = new Cat();
		
		for(Moveable m3: m2) {
			m3.move();
		}
	}

}
