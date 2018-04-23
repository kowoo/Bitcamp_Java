
public class a2 {
	//2차원 좌표값을 저장하는 클래스
	//x(정수), y(정수)
	//getter, setter, toString 만들자
	
	private int x, y;
	
	public a2() {
		x=0;
		y=0;
	}
	
	public a2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "x : "+this.x+", y : "+this.y;
	}
	
	
}
