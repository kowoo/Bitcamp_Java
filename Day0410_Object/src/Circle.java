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
public class Circle {
	private Point center;
	private int radius;
	
	public Circle() {	
		//개발자가 초기화를 하지 않으면, 참조 자료형의 경우 null로 초기화
		center = new Point();
	}
	
	public Circle(int radius, Point center) { // Point e에 test에서 보낸 주소값이 들어온다
		this.radius = radius;
		this.center = center; // 멤버 변수 e로 받은 주소값을 넣어준다
	}
	public Circle(int radius, int x, int y) { //위의 방식 대신 이런 방식을 써도 된다.
		this.radius = radius;
		center = new Point();
		center.setX(x);
		center.setY(y);
	}
//	public double area() {
//		return 3.14*radius*radius;
//		//System.out.println(center.getX()+" "+center.getY());
//	}
	public String circum() {
		return String.format("둘레 : %.2f", 3.14*radius*2);
	}
	public String area() {
		return String.format("넓이: %.2f", 3.14*radius*radius);
	}
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public Point getE() {
		return center;
	}
	
	public void setE(Point center) {
		this.center = center;
	}
	
	public String toString() {
		return String.format("반지름은 %d, 넓이는 %.2f", radius, 3.14*radius*radius);
	}
	
	public void printE() {
		System.out.println("x : "+ center.getX()+ " y : "+ center.getY());
	}
	
	public void printT() {
		System.out.println(center.getX()+", "+center.getY());
	}
	
}
