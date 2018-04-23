/*
Point 객체를 멤버변수로 가지는 클래스 만들어 보기
Circle
중심점(Point) center, 반지름의 상태값을 가짐 radius
getter, setter, toString() 만들자
생성자 (기본생성자, 반지름과 중심점을 매개변수로 받는 생성자)
메서드
넓이를 반환하는 메서드(3.14*radius*radius),
둘레를 반환하는 메서드(2*3.14*radius)
*/
public class CircleTest {
	public static void main(String[] args) {
		Point center = new Point(3,4); // Point 클래스를 이용해 만든 변수 e라는 이름의 객체
		Circle c = new Circle(5, center); // Circle 클래스를 이용해 만든 변수 c라는 이름의 객체
		c.area();
		c.circum();
		System.out.println(c.area());

		System.out.println(c);
		
		center.setX(5);
		center.setY(5);
		System.out.println(center);
	}
}
