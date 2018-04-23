package generic2;

public class Shape {
	protected String name;
	protected int numOfLines;
	protected double area;

	public Shape() {
		name="";
		numOfLines=0;
		area=0;
	}
	public Shape(String name, int numOfLines, double area) {
		this.name = name;
		this.numOfLines = numOfLines;
		this.area = area;
	}

	public void draw() {
		System.out.println("도형을 그립니다.");
	}
	public void calArea() {
		area=0;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", numOfLines=" + numOfLines + ", area=" + area + "]";
	}

	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}

	public int getNumOfLines() {
		return numOfLines;
	}

	public void setNumOfLines(int numOfLines) {
		this.numOfLines = numOfLines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
