package ex3;

public class ShapeTest {
	public static void main(String[] args) {
		//이해 해야 하는 내용
		//1. 상속시, 자식클래스의 객체는 부모클래스의 참조변수에 참조 가능하다.
		//2. 자식클래스의 객체가 부모클래스의 참조변수에 참조되어 있으면
		//	  자식클래스에서 새롭게 생성된 변수나 메서드는 참조하지 못한다.
		//	  사용하려면 자식클래스로 형변환이 필요하다.
		//3. 자식클래스에서 부모클래스가 가지는 메서드를 재정의(오버라이딩)하였다면
		//	  부모클래스의 참조변수에서 해당 메서드를 실행하더라도
		//	  자식클래스에 오버라이딩된 메서드가 실행된다(동적바인딩==다형성)

		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle(5);
		shapes[1] = new Triangle(3, 4);
		shapes[2] = new Rectangle(3, 4);

		for(Shape s: shapes) {
			s.calArea();
			System.out.println(s);
		}
	}
}
