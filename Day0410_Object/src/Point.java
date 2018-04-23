
public class Point {
	//2차원 좌표값을 저장하는 클래스
	//x(정수), y(정수)
	//getter, setter, toString 만들자
	private int x;
	private int y;

	public Point() {
		//기본 생성자, 멤버 변수의 초기화를 담당
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y; // this로 멤버변수를 지칭.
	}

	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "중심 좌표는 "+this.x+", "+this.y;
	}

}
