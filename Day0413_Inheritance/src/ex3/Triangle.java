package ex3;
//draw(),calArea(),toString() 오버라이딩
public class Triangle extends Shape {
	//정삼각형임 :)
	private int base;
	private int height;

	public Triangle() {
		super("정삼각형", 3, 0);
		base=0;
		height=0;
	}
	public Triangle(int base, int height) {
		super("정삼각형", 3, 0);
		this.base = base;
		this.height = height;
	}
	public void draw() {
		System.out.println("정삼각형을 그립니다.");
	}
	public void calArea() {
		area = base*height*0.5; 
	}
	@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + "]" + super.toString();
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
