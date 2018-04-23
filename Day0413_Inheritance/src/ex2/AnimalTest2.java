package ex2;

public class AnimalTest2 {
	public static void main(String[] args) {
		Cat c = new Cat();
		Dog d = new Dog();
		c.sound(); // 동적바인딩
		d.sound();
		
	}
}
//부모클래스의 참조변수를 통해서는 자식 클래스의 기능, 변수를 사용할 수 없다.
//굳이 사용하고 싶다면 형변환을 통해서 사용해야 한다.
//((SportsCar)c1).turboOn(); 이렇게 사용하거나
//SportsCar c2 = (SportsCar)c1;
//c2.turboOn(); 				이렇게 사용할 수 있다
