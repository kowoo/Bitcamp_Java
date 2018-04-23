package abstract1;
//draw(),calArea(),toString() 오버라이딩
public class Circle extends Shape {
	private int radius;
	public static final double PI = 3.14;
	
	
	public Circle() {
		super("원", 1, 0);
	}
	public Circle(int radius) {
		super("원", 1, 0);
		this.radius=radius;
	}
	public void draw() {
		System.out.println("원을 그립니다.");
	}
	public void calArea() {
		area= radius*radius*3.14;
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]" + super.toString();
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
}
