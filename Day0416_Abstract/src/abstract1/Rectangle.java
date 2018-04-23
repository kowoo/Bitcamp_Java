package abstract1;
public class Rectangle extends Shape {
	private int width;
	private int column;
	public Rectangle() {
		super("사각형", 4, 0);
		width=0;
		column=0;
	}
	public Rectangle(int width, int column) {
		super("사각형", 4, 0);
		this.width = width;
		this.column = column;
	}
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
	public void calArea() {
		area = width*column;
	}
	
@Override
	public String toString() {
		return "Rectangle [width=" + width + ", column=" + column + ", name=" + name + ", numOfLines=" + numOfLines
				+ ", area=" + area + "]";
	}
	//	@Override
//	public String toString() {
//		return "Rectangle [width=" + width + ", column=" + column + "]" + super.toString();
//	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
}
